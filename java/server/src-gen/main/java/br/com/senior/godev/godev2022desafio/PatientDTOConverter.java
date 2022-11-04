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

@Component("godev.godev2022desafio.PatientDTOConverter")
@Lazy
public class PatientDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(PatientDTOConverter.class);
	
	private DoctorDTOConverter doctorDTOConverter;
	private ResponsibleFamilyMemberDTOConverter responsibleFamilyMemberDTOConverter;
	private PrescriptionDTOConverter prescriptionDTOConverter;
	
	@Inject
	public void setDoctorDTOConverter(DoctorDTOConverter doctorDTOConverter) {
		this.doctorDTOConverter = doctorDTOConverter;
	}
	
	@Inject
	public void setResponsibleFamilyMemberDTOConverter(ResponsibleFamilyMemberDTOConverter responsibleFamilyMemberDTOConverter) {
		this.responsibleFamilyMemberDTOConverter = responsibleFamilyMemberDTOConverter;
	}
	
	@Inject
	public void setPrescriptionDTOConverter(PrescriptionDTOConverter prescriptionDTOConverter) {
		this.prescriptionDTOConverter = prescriptionDTOConverter;
	}
	
	public PatientEntity toEntity(Patient dto, boolean createMethod) {
		PatientEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public PatientEntity toEntity(Patient dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	PatientEntity toEntity(Patient dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		PatientEntity entity = (PatientEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new PatientEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public PatientEntity mergeEntity(PatientEntity entity, Patient dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	PatientEntity mergeEntity(PatientEntity entity, Patient dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.name != null) {
			entity.setName(dto.name);
		}
		if (dto.cpf != null) {
			entity.setCpf(dto.cpf);
		}
		if (dto.address != null) {
			entity.setAddress(dto.address);
		}
		if (dto.phone != null) {
			entity.setPhone(dto.phone);
		}
		if (dto.responsibleDoctors != null) {
			entity.setResponsibleDoctors(doctorDTOConverter.toEntityList(dto.responsibleDoctors, converted));
		}
		
		if (dto.responsibleFamilyMembers != null) {
			entity.setResponsibleFamilyMembers(responsibleFamilyMemberDTOConverter.toEntityList(dto.responsibleFamilyMembers, converted));
		}
		
		if (dto.prescriptions != null) {
			entity.setPrescriptions(prescriptionDTOConverter.toEntityList(dto.prescriptions, converted));
		}
		
		if (dto.isAtivo != null) {
			entity.setIsAtivo(dto.isAtivo);
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public PatientEntity updateEntity(PatientEntity entity, Patient dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	PatientEntity updateEntity(PatientEntity entity, Patient dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setName(dto.name);
		entity.setCpf(dto.cpf);
		entity.setAddress(dto.address);
		entity.setPhone(dto.phone);
		entity.setResponsibleDoctors(doctorDTOConverter.toEntityList(dto.responsibleDoctors, converted));
		
		entity.setResponsibleFamilyMembers(responsibleFamilyMemberDTOConverter.toEntityList(dto.responsibleFamilyMembers, converted));
		
		entity.setPrescriptions(prescriptionDTOConverter.toEntityList(dto.prescriptions, converted));
		
		entity.setIsAtivo(dto.isAtivo);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<PatientEntity> toEntityList(java.util.List<Patient> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<PatientEntity> toEntityList(java.util.List<Patient> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<PatientEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Patient toDTO(PatientEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Patient toDTO(PatientEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Patient dto = (Patient) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Patient();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.name = entity.getName();
		dto.cpf = entity.getCpf();
		dto.address = entity.getAddress();
		dto.phone = entity.getPhone();
		dto.responsibleDoctors = doctorDTOConverter.toDTOList(entity.getResponsibleDoctors(), converted);
		dto.responsibleFamilyMembers = responsibleFamilyMemberDTOConverter.toDTOList(entity.getResponsibleFamilyMembers(), converted);
		dto.prescriptions = prescriptionDTOConverter.toDTOList(entity.getPrescriptions(), converted);
		dto.isAtivo = entity.getIsAtivo();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Patient toDTO(PatientEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Patient toDTO(PatientEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Patient dto = new Patient();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "address".equals(displayField) || "*".equals(displayField))) {
			dto.address = entity.getAddress();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "phone".equals(displayField) || "*".equals(displayField))) {
			dto.phone = entity.getPhone();
		}
		
		List<String> responsibleDoctorsDisplayFields = displayFields.stream()
			.filter(displayField -> displayField.trim().startsWith("responsibleDoctors.")).map(f -> f.substring("responsibleDoctors.".length() + f.indexOf("responsibleDoctors.")).trim()).collect(Collectors.toList());
		if (!responsibleDoctorsDisplayFields.isEmpty()) {
			dto.responsibleDoctors = new java.util.ArrayList<>();
			for (DoctorEntity doctorEntity : entity.getResponsibleDoctors()) {
				dto.responsibleDoctors.add(doctorDTOConverter.toDTO(doctorEntity, responsibleDoctorsDisplayFields, converted));
			}
		}
		
		List<String> responsibleFamilyMembersDisplayFields = displayFields.stream()
			.filter(displayField -> displayField.trim().startsWith("responsibleFamilyMembers.")).map(f -> f.substring("responsibleFamilyMembers.".length() + f.indexOf("responsibleFamilyMembers.")).trim()).collect(Collectors.toList());
		if (!responsibleFamilyMembersDisplayFields.isEmpty()) {
			dto.responsibleFamilyMembers = new java.util.ArrayList<>();
			for (ResponsibleFamilyMemberEntity responsibleFamilyMemberEntity : entity.getResponsibleFamilyMembers()) {
				dto.responsibleFamilyMembers.add(responsibleFamilyMemberDTOConverter.toDTO(responsibleFamilyMemberEntity, responsibleFamilyMembersDisplayFields, converted));
			}
		}
		
		List<String> prescriptionsDisplayFields = displayFields.stream()
			.filter(displayField -> displayField.trim().startsWith("prescriptions.")).map(f -> f.substring("prescriptions.".length() + f.indexOf("prescriptions.")).trim()).collect(Collectors.toList());
		if (!prescriptionsDisplayFields.isEmpty()) {
			dto.prescriptions = new java.util.ArrayList<>();
			for (PrescriptionEntity prescriptionEntity : entity.getPrescriptions()) {
				dto.prescriptions.add(prescriptionDTOConverter.toDTO(prescriptionEntity, prescriptionsDisplayFields, converted));
			}
		}
		
		if (displayFields.stream().anyMatch(displayField -> "isAtivo".equals(displayField) || "*".equals(displayField))) {
			dto.isAtivo = entity.getIsAtivo();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Patient toDTOforRelation(PatientEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Patient dto = new Patient();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "address".equals(displayField) || "*".equals(displayField))) {
			dto.address = entity.getAddress();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "phone".equals(displayField) || "*".equals(displayField))) {
			dto.phone = entity.getPhone();
		}
		
		
		
		
		if (displayFields.stream().anyMatch(displayField -> "isAtivo".equals(displayField) || "*".equals(displayField))) {
			dto.isAtivo = entity.getIsAtivo();
		}
        return dto;
    }
    
    public java.util.List<Patient> toDTOList(java.util.List<PatientEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Patient> toDTOList(java.util.List<PatientEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Patient> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Patient> toDTOList(java.util.Set<PatientEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Patient> toDTOList(java.util.Set<PatientEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Patient> dtos = null;
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
	
	private void treatJsonPath(PatientEntity entity, JsonPatch jsonPatch) {
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
		if("address".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setAddress(null);
		}
		if("phone".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setPhone(null);
		}
		if("responsibleDoctors".equals(jsonPatch.getPath().replace("/", ""))) {
			for (DoctorEntity e : new java.util.ArrayList<>(entity.getResponsibleDoctors())) {
				entity.removeFromResponsibleDoctors(e);
			}
		}
		if("responsibleFamilyMembers".equals(jsonPatch.getPath().replace("/", ""))) {
			for (ResponsibleFamilyMemberEntity e : new java.util.ArrayList<>(entity.getResponsibleFamilyMembers())) {
				entity.removeFromResponsibleFamilyMembers(e);
			}
		}
		if("prescriptions".equals(jsonPatch.getPath().replace("/", ""))) {
			for (PrescriptionEntity e : new java.util.ArrayList<>(entity.getPrescriptions())) {
				entity.removeFromPrescriptions(e);
			}
		}
		if("isAtivo".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setIsAtivo(null);
		}
	}
}
