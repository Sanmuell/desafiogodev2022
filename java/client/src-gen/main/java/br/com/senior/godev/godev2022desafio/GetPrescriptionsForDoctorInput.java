package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class GetPrescriptionsForDoctorInput {
    
    /**
     * Nome do médico
     */
    public String name;
    
    
    public GetPrescriptionsForDoctorInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetPrescriptionsForDoctorInput(String name) {
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
        if (!(obj instanceof GetPrescriptionsForDoctorInput)) {
            return false;
        }
        GetPrescriptionsForDoctorInput other = (GetPrescriptionsForDoctorInput) obj;
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
    	GetPrescriptionsForDoctorInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
