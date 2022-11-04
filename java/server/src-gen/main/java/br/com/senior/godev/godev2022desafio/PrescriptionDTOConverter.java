/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Component("godev.godev2022desafio.PrescriptionDTOConverter")
@Lazy
public class PrescriptionDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(PrescriptionDTOConverter.class);
	
	private DoctorDTOConverter doctorDTOConverter;
	private PatientDTOConverter patientDTOConverter;
	
	@Inject
	public void setDoctorDTOConverter(DoctorDTOConverter doctorDTOConverter) {
		this.doctorDTOConverter = doctorDTOConverter;
	}
	
	@Inject
	public void setPatientDTOConverter(PatientDTOConverter patientDTOConverter) {
		this.patientDTOConverter = patientDTOConverter;
	}
	
	public PrescriptionEntity toEntity(Prescription dto, boolean createMethod) {
		PrescriptionEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public PrescriptionEntity toEntity(Prescription dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	PrescriptionEntity toEntity(Prescription dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		PrescriptionEntity entity = (PrescriptionEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new PrescriptionEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public PrescriptionEntity mergeEntity(PrescriptionEntity entity, Prescription dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	PrescriptionEntity mergeEntity(PrescriptionEntity entity, Prescription dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.drug != null) {
			entity.setDrug(dto.drug);
		}
		if (dto.description != null) {
			entity.setDescription(dto.description);
		}
		if (dto.data != null) {
			entity.setData(dto.data);
		}
		if (dto.doctorResponsible != null) {
			entity.setDoctorResponsible(doctorDTOConverter.toEntity(dto.doctorResponsible, converted));
		}
		
		if (dto.type != null) {
			entity.setType(dto.type);
		}
		if (dto.statementOfReponsability != null) {
			entity.setStatementOfReponsability(dto.statementOfReponsability);
		}
		if (dto.patient != null) {
			entity.setPatient(patientDTOConverter.toEntity(dto.patient, converted));
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public PrescriptionEntity updateEntity(PrescriptionEntity entity, Prescription dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	PrescriptionEntity updateEntity(PrescriptionEntity entity, Prescription dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setDrug(dto.drug);
		entity.setDescription(dto.description);
		entity.setData(dto.data);
		entity.setDoctorResponsible(doctorDTOConverter.toEntity(dto.doctorResponsible, converted));
		
		entity.setType(dto.type);
		entity.setStatementOfReponsability(dto.statementOfReponsability);
		entity.setPatient(patientDTOConverter.toEntity(dto.patient, converted));
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<PrescriptionEntity> toEntityList(java.util.List<Prescription> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<PrescriptionEntity> toEntityList(java.util.List<Prescription> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<PrescriptionEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Prescription toDTO(PrescriptionEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Prescription toDTO(PrescriptionEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Prescription dto = (Prescription) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Prescription();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.drug = entity.getDrug();
		dto.description = entity.getDescription();
		dto.data = entity.getData();
		dto.doctorResponsible = doctorDTOConverter.toDTO(entity.getDoctorResponsible(), converted);
		dto.type = entity.getType();
		dto.statementOfReponsability = entity.getStatementOfReponsability();
		dto.patient = patientDTOConverter.toDTO(entity.getPatient(), converted);
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Prescription toDTO(PrescriptionEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Prescription toDTO(PrescriptionEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Prescription dto = new Prescription();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "drug".equals(displayField) || "*".equals(displayField))) {
			dto.drug = entity.getDrug();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "description".equals(displayField) || "*".equals(displayField))) {
			dto.description = entity.getDescription();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "data".equals(displayField) || "*".equals(displayField))) {
			dto.data = entity.getData();
		}
		
		List<String> doctorResponsibleDisplayFields = displayFields.stream()
						.filter(displayField -> displayField.trim().startsWith("doctorResponsible.")).map(f -> f.substring("doctorResponsible.".length() + f.indexOf("doctorResponsible.")).trim()).collect(Collectors.toList());
		if (!doctorResponsibleDisplayFields.isEmpty()) {
			dto.doctorResponsible = doctorDTOConverter.toDTO(entity.getDoctorResponsible(), doctorResponsibleDisplayFields, new java.util.HashMap<Object, Object>());
		}
		
		if (displayFields.stream().anyMatch(displayField -> "type".equals(displayField) || "*".equals(displayField))) {
			dto.type = entity.getType();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "statementOfReponsability".equals(displayField) || "*".equals(displayField))) {
			dto.statementOfReponsability = entity.getStatementOfReponsability();
		}
		
		List<String> patientDisplayFields = displayFields.stream()
						.filter(displayField -> displayField.trim().startsWith("patient.")).map(f -> f.substring("patient.".length() + f.indexOf("patient.")).trim()).collect(Collectors.toList());
		if (!patientDisplayFields.isEmpty()) {
			dto.patient = patientDTOConverter.toDTO(entity.getPatient(), patientDisplayFields, new java.util.HashMap<Object, Object>());
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Prescription toDTOforRelation(PrescriptionEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Prescription dto = new Prescription();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "drug".equals(displayField) || "*".equals(displayField))) {
			dto.drug = entity.getDrug();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "description".equals(displayField) || "*".equals(displayField))) {
			dto.description = entity.getDescription();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "data".equals(displayField) || "*".equals(displayField))) {
			dto.data = entity.getData();
		}
		
		
		if (displayFields.stream().anyMatch(displayField -> "type".equals(displayField) || "*".equals(displayField))) {
			dto.type = entity.getType();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "statementOfReponsability".equals(displayField) || "*".equals(displayField))) {
			dto.statementOfReponsability = entity.getStatementOfReponsability();
		}
		
        return dto;
    }
    
    public java.util.List<Prescription> toDTOList(java.util.List<PrescriptionEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Prescription> toDTOList(java.util.List<PrescriptionEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Prescription> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Prescription> toDTOList(java.util.Set<PrescriptionEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Prescription> toDTOList(java.util.Set<PrescriptionEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Prescription> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
        
	private static Set<Field> findFields(Class<?> clazz, Class<? extends Annotation> ann) {
		Set<Field> set = new HashSet<>();
		Class<?> c = clazz;
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(ann)) {
					set.add(field);
				}
			}
			c = c.getSuperclass();
		}
		return set;
	}
	
	private void treatJsonPath(PrescriptionEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("drug".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setDrug(null);
		}
		if("description".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setDescription(null);
		}
		if("data".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setData(null);
		}
		if("doctorResponsible".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setDoctorResponsible(null);
		}
		if("type".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setType(null);
		}
		if("statementOfReponsability".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setStatementOfReponsability(null);
		}
		if("patient".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setPatient(null);
		}
	}
}
