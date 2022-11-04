package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


/**
 * Retorno de usuario ativo
 */
public class PatientResponse {
    
    /**
     * Nome do paciente
     */
    @NotNull(message = "name is required")
    public String name;
    
    /**
     * Status do paciente
     */
    @NotNull(message = "isAtivo is required")
    public Boolean isAtivo;
    
    
    public PatientResponse() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public PatientResponse(String name, Boolean isAtivo) {
        this.name = name;
        this.isAtivo = isAtivo;
    }
    
    public void validate() {
        validate(true);
    }
    
    public void validate(boolean required) {
        validate(null, required);
    }
    
    public void validate(Map<String, Object> headers, boolean required) {
    	validate(headers, required, new ArrayList<>());
    }
    
    public void validate(Map<String, Object> headers, boolean required, List<Object> validated) {
    	Godev2022desafioValidator.validate(this, headers, required, validated);
    }
    @Override
    public int hashCode() {
        int ret = 1;
        if (name != null) {
            ret = 31 * ret + name.hashCode();
        }
        if (isAtivo != null) {
            ret = 31 * ret + isAtivo.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatientResponse)) {
            return false;
        }
        PatientResponse other = (PatientResponse) obj;
        if ((name == null) != (other.name == null)) {
            return false;
        }
        if ((name != null) && !name.equals(other.name)) {
            return false;
        }
        if ((isAtivo == null) != (other.isAtivo == null)) {
            return false;
        }
        if ((isAtivo != null) && !isAtivo.equals(other.isAtivo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	toString(sb, new ArrayList<>());
    	return sb.toString();
    }
    
    public void toString(StringBuilder sb, List<Object> appended) {
    	PatientResponseStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
