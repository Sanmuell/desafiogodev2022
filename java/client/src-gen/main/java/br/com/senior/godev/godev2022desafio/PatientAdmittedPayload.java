package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class PatientAdmittedPayload {
    
    /**
     * Id do paciente
     */
    @NotNull(message = "id is required")
    public String id;
    
    /**
     * Nome do paciente
     */
    @NotNull(message = "name is required")
    public String name;
    
    
    public PatientAdmittedPayload() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public PatientAdmittedPayload(String id, String name) {
        this.id = id;
        this.name = name;
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
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        if (name != null) {
            ret = 31 * ret + name.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatientAdmittedPayload)) {
            return false;
        }
        PatientAdmittedPayload other = (PatientAdmittedPayload) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((name == null) != (other.name == null)) {
            return false;
        }
        if ((name != null) && !name.equals(other.name)) {
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
    	PatientAdmittedPayloadStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
