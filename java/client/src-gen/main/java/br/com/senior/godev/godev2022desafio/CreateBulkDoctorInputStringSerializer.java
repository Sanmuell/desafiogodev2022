package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkDoctorInputStringSerializer {
    
	public static final CreateBulkDoctorInputStringSerializer INSTANCE = new CreateBulkDoctorInputStringSerializer();
    
    public void serialize(CreateBulkDoctorInput createBulkDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkDoctorInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkDoctorInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkDoctorInput);
		serializeEntities(createBulkDoctorInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkDoctorInput createBulkDoctorInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkDoctorInput.entities == null ? "null" : createBulkDoctorInput.entities);
	}
}
