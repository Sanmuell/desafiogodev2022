package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.Valid;


public class GetDoctorForSpecialityOutput {
    
    /**
     * retorno
     */
    @NotEmpty(message = "doctor is required, at least one value must be present")
    @Valid
    public java.util.List<Doctor> doctor;
    
    
    public GetDoctorForSpecialityOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetDoctorForSpecialityOutput(java.util.List<Doctor> doctor) {
        this.doctor = doctor;
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
        if (doctor != null) {
            ret = 31 * ret + doctor.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetDoctorForSpecialityOutput)) {
            return false;
        }
        GetDoctorForSpecialityOutput other = (GetDoctorForSpecialityOutput) obj;
        if ((doctor == null) != (other.doctor == null)) {
            return false;
        }
        if ((doctor != null) && !doctor.equals(other.doctor)) {
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
    	GetDoctorForSpecialityOutputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
