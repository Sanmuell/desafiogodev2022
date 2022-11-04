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
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Component("godev.godev2022desafio.ResponsibleFamilyMemberDTOConverter")
@Lazy
public class ResponsibleFamilyMemberDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(ResponsibleFamilyMemberDTOConverter.class);
	
	
	public ResponsibleFamilyMemberEntity toEntity(ResponsibleFamilyMember dto, boolean createMethod) {
		ResponsibleFamilyMemberEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public ResponsibleFamilyMemberEntity toEntity(ResponsibleFamilyMember dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	ResponsibleFamilyMemberEntity toEntity(ResponsibleFamilyMember dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		ResponsibleFamilyMemberEntity entity = (ResponsibleFamilyMemberEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new ResponsibleFamilyMemberEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public ResponsibleFamilyMemberEntity mergeEntity(ResponsibleFamilyMemberEntity entity, ResponsibleFamilyMember dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	ResponsibleFamilyMemberEntity mergeEntity(ResponsibleFamilyMemberEntity entity, ResponsibleFamilyMember dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.name != null) {
			entity.setName(dto.name);
		}
		if (dto.cpf != null) {
			entity.setCpf(dto.cpf);
		}
		if (dto.kinship != null) {
			entity.setKinship(dto.kinship);
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public ResponsibleFamilyMemberEntity updateEntity(ResponsibleFamilyMemberEntity entity, ResponsibleFamilyMember dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	ResponsibleFamilyMemberEntity updateEntity(ResponsibleFamilyMemberEntity entity, ResponsibleFamilyMember dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setName(dto.name);
		entity.setCpf(dto.cpf);
		entity.setKinship(dto.kinship);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<ResponsibleFamilyMemberEntity> toEntityList(java.util.List<ResponsibleFamilyMember> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<ResponsibleFamilyMemberEntity> toEntityList(java.util.List<ResponsibleFamilyMember> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<ResponsibleFamilyMemberEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public ResponsibleFamilyMember toDTO(ResponsibleFamilyMemberEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	ResponsibleFamilyMember toDTO(ResponsibleFamilyMemberEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		ResponsibleFamilyMember dto = (ResponsibleFamilyMember) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new ResponsibleFamilyMember();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.name = entity.getName();
		dto.cpf = entity.getCpf();
		dto.kinship = entity.getKinship();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public ResponsibleFamilyMember toDTO(ResponsibleFamilyMemberEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	ResponsibleFamilyMember toDTO(ResponsibleFamilyMemberEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        ResponsibleFamilyMember dto = new ResponsibleFamilyMember();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "kinship".equals(displayField) || "*".equals(displayField))) {
			dto.kinship = entity.getKinship();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    ResponsibleFamilyMember toDTOforRelation(ResponsibleFamilyMemberEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        ResponsibleFamilyMember dto = new ResponsibleFamilyMember();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "name".equals(displayField) || "*".equals(displayField))) {
			dto.name = entity.getName();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cpf".equals(displayField) || "*".equals(displayField))) {
			dto.cpf = entity.getCpf();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "kinship".equals(displayField) || "*".equals(displayField))) {
			dto.kinship = entity.getKinship();
		}
        return dto;
    }
    
    public java.util.List<ResponsibleFamilyMember> toDTOList(java.util.List<ResponsibleFamilyMemberEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<ResponsibleFamilyMember> toDTOList(java.util.List<ResponsibleFamilyMemberEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<ResponsibleFamilyMember> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<ResponsibleFamilyMember> toDTOList(java.util.Set<ResponsibleFamilyMemberEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<ResponsibleFamilyMember> toDTOList(java.util.Set<ResponsibleFamilyMemberEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<ResponsibleFamilyMember> dtos = null;
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
	
	private void treatJsonPath(ResponsibleFamilyMemberEntity entity, JsonPatch jsonPatch) {
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
		if("kinship".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setKinship(null);
		}
	}
}
