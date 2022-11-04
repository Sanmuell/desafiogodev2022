package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkPrescriptionInputStringSerializer {
    
	public static final CreateBulkPrescriptionInputStringSerializer INSTANCE = new CreateBulkPrescriptionInputStringSerializer();
    
    public void serialize(CreateBulkPrescriptionInput createBulkPrescriptionInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPrescriptionInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPrescriptionInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPrescriptionInput);
		serializeEntities(createBulkPrescriptionInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkPrescriptionInput createBulkPrescriptionInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkPrescriptionInput.entities == null ? "null" : createBulkPrescriptionInput.entities);
	}
}
