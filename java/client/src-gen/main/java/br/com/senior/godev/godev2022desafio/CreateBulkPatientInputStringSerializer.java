package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkPatientInputStringSerializer {
    
	public static final CreateBulkPatientInputStringSerializer INSTANCE = new CreateBulkPatientInputStringSerializer();
    
    public void serialize(CreateBulkPatientInput createBulkPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPatientInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPatientInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPatientInput);
		serializeEntities(createBulkPatientInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkPatientInput createBulkPatientInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkPatientInput.entities == null ? "null" : createBulkPatientInput.entities);
	}
}
