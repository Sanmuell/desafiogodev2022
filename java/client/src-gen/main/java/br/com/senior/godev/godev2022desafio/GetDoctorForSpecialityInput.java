package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class GetDoctorForSpecialityInput {
    
    /**
     * Especialidade do médico
     */
    @NotNull(message = "speciality is required")
    public String speciality;
    
    
    public GetDoctorForSpecialityInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetDoctorForSpecialityInput(String speciality) {
        this.speciality = speciality;
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
        if (speciality != null) {
            ret = 31 * ret + speciality.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetDoctorForSpecialityInput)) {
            return false;
        }
        GetDoctorForSpecialityInput other = (GetDoctorForSpecialityInput) obj;
        if ((speciality == null) != (other.speciality == null)) {
            return false;
        }
        if ((speciality != null) && !speciality.equals(other.speciality)) {
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
    	GetDoctorForSpecialityInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
