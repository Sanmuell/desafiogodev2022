package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.Valid;


public class GetPrescriptionsForDoctorOutput {
    
    /**
     * Resultado das prescricoes vinculadas ao nome do médico
     */
    @NotEmpty(message = "prescription is required, at least one value must be present")
    @Valid
    public java.util.List<Prescription> prescription;
    
    
    public GetPrescriptionsForDoctorOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetPrescriptionsForDoctorOutput(java.util.List<Prescription> prescription) {
        this.prescription = prescription;
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
        if (prescription != null) {
            ret = 31 * ret + prescription.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPrescriptionsForDoctorOutput)) {
            return false;
        }
        GetPrescriptionsForDoctorOutput other = (GetPrescriptionsForDoctorOutput) obj;
        if ((prescription == null) != (other.prescription == null)) {
            return false;
        }
        if ((prescription != null) && !prescription.equals(other.prescription)) {
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
    	GetPrescriptionsForDoctorOutputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
