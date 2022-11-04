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

@Component("godev.godev2022desafio.DoctorDTOConverter")
@Lazy
public class DoctorDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(DoctorDTOConverter.class);
	
	private PrescriptionDTOConverter prescriptionDTOConverter;
	
	@Inject
	public void setPrescriptionDTOConverter(PrescriptionDTOConverter prescriptionDTOConverter) {
		this.prescriptionDTOConverter = prescriptionDTOConverter;
	}
	
	public DoctorEntity toEntity(Doctor dto, boolean createMethod) {
		DoctorEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public DoctorEntity toEntity(Doctor dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	DoctorEntity toEntity(Doctor dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		DoctorEntity entity = (DoctorEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new DoctorEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public DoctorEntity mergeEntity(DoctorEntity entity, Doctor dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	DoctorEntity mergeEntity(DoctorEntity entity, Doctor dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.name != null) {
			entity.setName(dto.name);
		}
		if (dto.cpf != null) {
			entity.setCpf(dto.cpf);
		}
		if (dto.crmNumber != null) {
			entity.setCrmNumber(dto.crmNumber);
		}
		if (dto.crmState != null) {
			entity.setCrmState(dto.crmState);
		}
		if (dto.especiality != null) {
			entity.setEspeciality(dto.especiality);
		}
		if (dto.prescriptions != null) {
			entity.getPrescriptions().clear();
			for (PrescriptionEntity detail : prescriptionDTOConverter.toEntityList(dto.prescriptions, converted)) {
				entity.addToPrescriptions(detail);
			}
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public DoctorEntity updateEntity(DoctorEntity entity, Doctor dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	DoctorEntity updateEntity(DoctorEntity entity, Doctor dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setName(dto.name);
		entity.setCpf(dto.cpf);
		entity.setCrmNumber(dto.crmNumber);
		entity.setCrmState(dto.crmState);
		entity.setEspeciality(dto.especiality);
		if (dto.prescriptions != null) {
			entity.getPrescriptions().clear();
			for (PrescriptionEntity detail : prescriptionDTOConverter.toEntityList(dto.prescriptions, converted)) {
				entity.addToPrescriptions(detail);
			}
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<DoctorEntity> toEntityList(java.util.List<Doctor> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<DoctorEntity> toEntityList(java.util.List<Doctor> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<DoctorEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Doctor toDTO(DoctorEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Doctor toDTO(DoctorEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Doctor dto = (Doctor) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Doctor();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.name = entity.getName();
		dto.cpf = entity.getCpf();
		dto.crmNumber = entity.getCrmNumber();
		dto.crmState = entity.getCrmState();
		dto.especiality = entity.getEspeciality();
		dto.prescriptions = prescriptionDTOConverter.toDTOList(entity.getPrescriptions(), converted);
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Doctor toDTO(DoctorEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Doctor toDTO(DoctorEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Doctor dto = new Doctor();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "crmNumber".equals(displayField) || "*".equals(displayField))) {
			dto.crmNumber = entity.getCrmNumber();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "crmState".equals(displayField) || "*".equals(displayField))) {
			dto.crmState = entity.getCrmState();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "especiality".equals(displayField) || "*".equals(displayField))) {
			dto.especiality = entity.getEspeciality();
		}
		
		List<String> prescriptionsDisplayFields = displayFields.stream()
			.filter(displayField -> displayField.trim().startsWith("prescriptions.")).map(f -> f.substring("prescriptions.".length() + f.indexOf("prescriptions.")).trim()).collect(Collectors.toList());
		if (!prescriptionsDisplayFields.isEmpty()) {
			dto.prescriptions = new java.util.ArrayList<>();
			for (PrescriptionEntity prescriptionEntity : entity.getPrescriptions()) {
				dto.prescriptions.add(prescriptionDTOConverter.toDTO(prescriptionEntity, prescriptionsDisplayFields, converted));
			}
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Doctor toDTOforRelation(DoctorEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Doctor dto = new Doctor();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "crmNumber".equals(displayField) || "*".equals(displayField))) {
			dto.crmNumber = entity.getCrmNumber();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "crmState".equals(displayField) || "*".equals(displayField))) {
			dto.crmState = entity.getCrmState();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "especiality".equals(displayField) || "*".equals(displayField))) {
			dto.especiality = entity.getEspeciality();
		}
		
        return dto;
    }
    
    public java.util.List<Doctor> toDTOList(java.util.List<DoctorEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Doctor> toDTOList(java.util.List<DoctorEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Doctor> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Doctor> toDTOList(java.util.Set<DoctorEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Doctor> toDTOList(java.util.Set<DoctorEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Doctor> dtos = null;
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
	
	private void treatJsonPath(DoctorEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("name".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setName(null);
		}
		if("cpf".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setCpf(null);
		}
		if("crmNumber".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setCrmNumber(null);
		}
		if("crmState".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setCrmState(null);
		}
		if("especiality".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setEspeciality(null);
		}
		if("prescriptions".equals(jsonPatch.getPath().replace("/", ""))) {
			for (PrescriptionEntity e : new java.util.ArrayList<>(entity.getPrescriptions())) {
				entity.removeFromPrescriptions(e);
			}
		}
	}
}
