package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;


public class ImportResponsibleFamilyMemberInput {
    
    @NotNull(message = "config is required")
    @Valid
    public ImportConfig config;
    
    
    public ImportResponsibleFamilyMemberInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ImportResponsibleFamilyMemberInput(ImportConfig config) {
        this.config = config;
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
        if (config != null) {
            ret = 31 * ret + config.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImportResponsibleFamilyMemberInput)) {
            return false;
        }
        ImportResponsibleFamilyMemberInput other = (ImportResponsibleFamilyMemberInput) obj;
        if ((config == null) != (other.config == null)) {
            return false;
        }
        if ((config != null) && !config.equals(other.config)) {
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
    	ImportResponsibleFamilyMemberInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
