package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;
import br.com.senior.custom.CustomDTO;

/**
 * Prescricao Médica
 */
@EntityDescription
public class Prescription extends CustomDTO {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String prescriptionId) {
            this.id = prescriptionId;
        }
        
        public String getPrescriptionId() {
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
    	
        public List<Prescription> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<Prescription> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<Prescription> contents, Long totalPages, Long totalElements) {
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
     * Id da prescricao
     */
    public String id;
    
    /**
     * Medicamento
     */
    @NotNull(message = "drug is required")
    public String drug;
    
    /**
     * Descricao da prescricao
     */
    @NotNull(message = "description is required")
    public String description;
    
    /**
     * Data da prescricao
     */
    @NotNull(message = "data is required")
    public java.time.LocalDate data;
    
    /**
     * Medico que prescreveu
     */
    @ValidEntity(message = "doctorResponsible.id is required")
    public Doctor doctorResponsible;
    
    /**
     * Tipo de prescricao
     */
    @NotNull(message = "type is required")
    public PrecriptionType type;
    
    /**
     * Termo de responsabildiade
     * 
     */
    public Boolean statementOfReponsability = false;
    
    /**
     * Paciente
     */
    @ValidEntity(message = "patient.id is required")
    public Patient patient;
    
    
	private List<JsonPatch> jsonPatches;
	
    public Prescription() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Prescription(String id, String drug, String description, java.time.LocalDate data, Doctor doctorResponsible, PrecriptionType type, Boolean statementOfReponsability, Patient patient, List<JsonPatch> jsonPatches) {
        this.id = id;
        this.drug = drug;
        this.description = description;
        this.data = data;
        this.doctorResponsible = doctorResponsible;
        this.type = type;
        this.statementOfReponsability = statementOfReponsability != null ? statementOfReponsability : false;
        this.patient = patient;
        this.jsonPatches = jsonPatches;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public Prescription(String drug, String description, java.time.LocalDate data, PrecriptionType type) {
        this.drug = drug;
        this.description = description;
        this.data = data;
        this.type = type;
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
        if (!(obj instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) obj;
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
    	PrescriptionStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
	
    public List<JsonPatch> getJsonPatches(){
    	return jsonPatches == null ? java.util.Collections.emptyList() : jsonPatches;
    }
}
