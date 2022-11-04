package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;
import br.com.senior.custom.CustomDTO;

/**
 * Médico
 */
@EntityDescription
public class Doctor extends CustomDTO {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String doctorId) {
            this.id = doctorId;
        }
        
        public String getDoctorId() {
            return id;
        }
        
        public String getId() {
            return id;
        }
        
    	public void normalize(Map<String, Object> headers) {
    		Godev2022desafioNormalizer.normalize(this, headers);
    	}
    	
    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<Doctor> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<Doctor> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<Doctor> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }
    
    public static class PageRequest {
        public Long offset;
        public Long size;
        public boolean translations;
        public String orderBy;
        public String filter;
        public List<String> displayFields;
        
        public PageRequest() {
        }
        
        public PageRequest(Long offset, Long size) {
            this(offset, size, null, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy) {
            this(offset, size, orderBy, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy, String filter) {
            this(offset, size, orderBy, filter, null);
       	}
        
        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields) {
            this.offset = offset;
        	this.size = size;
        	this.orderBy = orderBy;
        	this.filter = filter;
        	this.displayFields = displayFields;
        }
    }
    			    
    public static class GetRequest {
        public String id;
        public List<String> displayFields;
        public boolean translations;
        
        public GetRequest() {
        }
        
        public GetRequest(String id) {
            this(id, null);
        }
        
        public GetRequest(String id, List<String> displayFields) {
            this.id = id;
            this.displayFields = displayFields;
        }
    }

    @EntityId
    /**
     * Id do medico
     */
    public String id;
    
    /**
     * Nome do medico
     */
    @NotNull(message = "name is required")
    public String name;
    
    /**
     * Cpf do medico
     */
    @NotNull(message = "cpf is required")
    public String cpf;
    
    /**
     * CRM do medico
     */
    @NotNull(message = "crmNumber is required")
    public Long crmNumber;
    
    /**
     * Estado do CRM do medico
     */
    @NotNull(message = "crmState is required")
    public String crmState;
    
    @NotNull(message = "especiality is required")
    public String especiality;
    
    /**
     * Prescrições
     */
    @ValidEntity(message = "prescriptions.id is required")
    public java.util.List<Prescription> prescriptions;
    
    
	private List<JsonPatch> jsonPatches;
	
    public Doctor() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Doctor(String id, String name, String cpf, Long crmNumber, String crmState, String especiality, java.util.List<Prescription> prescriptions, List<JsonPatch> jsonPatches) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.crmNumber = crmNumber;
        this.crmState = crmState;
        this.especiality = especiality;
        this.prescriptions = prescriptions;
        this.jsonPatches = jsonPatches;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public Doctor(String name, String cpf, Long crmNumber, String crmState, String especiality) {
        this.name = name;
        this.cpf = cpf;
        this.crmNumber = crmNumber;
        this.crmState = crmState;
        this.especiality = especiality;
    }
    
    public void normalize(Map<String, Object> headers) {
    	Godev2022desafioNormalizer.normalize(this, headers);
    }
    
    public void validate() {
    	validate(true);
    }
    
    public void validate(boolean required) {
    	validate(null, true);
    }
    
    public void validate(Map<String, Object> headers, boolean required) {
    	validate(headers, required, new ArrayList<>());
    }
    
    void validate(Map<String, Object> headers, boolean required, List<Object> validated) {
    	Godev2022desafioValidator.validate(this, headers, required, validated);
    }
    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) obj;
        if (id == null || !id.equals(other.id)) {
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
    	DoctorStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
	
    public List<JsonPatch> getJsonPatches(){
    	return jsonPatches == null ? java.util.Collections.emptyList() : jsonPatches;
    }
}
