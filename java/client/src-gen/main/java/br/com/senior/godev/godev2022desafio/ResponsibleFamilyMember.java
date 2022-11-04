package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;
import br.com.senior.custom.CustomDTO;

/**
 * Familiar Responsável
 */
@EntityDescription
public class ResponsibleFamilyMember extends CustomDTO {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String responsibleFamilyMemberId) {
            this.id = responsibleFamilyMemberId;
        }
        
        public String getResponsibleFamilyMemberId() {
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
    	
        public List<ResponsibleFamilyMember> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<ResponsibleFamilyMember> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<ResponsibleFamilyMember> contents, Long totalPages, Long totalElements) {
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
     * Id do Familiar Responsável
     */
    public String id;
    
    /**
     * Nome do Responsável
     */
    @NotNull(message = "name is required")
    public String name;
    
    /**
     * Cpf do responsável
     */
    @NotNull(message = "cpf is required")
    public String cpf;
    
    /**
     * Grau de parentesco
     */
    public String kinship;
    
    
	private List<JsonPatch> jsonPatches;
	
    public ResponsibleFamilyMember() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ResponsibleFamilyMember(String id, String name, String cpf, String kinship, List<JsonPatch> jsonPatches) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.kinship = kinship;
        this.jsonPatches = jsonPatches;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public ResponsibleFamilyMember(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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
        if (!(obj instanceof ResponsibleFamilyMember)) {
            return false;
        }
        ResponsibleFamilyMember other = (ResponsibleFamilyMember) obj;
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
    	ResponsibleFamilyMemberStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
	
    public List<JsonPatch> getJsonPatches(){
    	return jsonPatches == null ? java.util.Collections.emptyList() : jsonPatches;
    }
}
