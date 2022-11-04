package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkPrescriptionOutputStringSerializer {
    
	public static final CreateBulkPrescriptionOutputStringSerializer INSTANCE = new CreateBulkPrescriptionOutputStringSerializer();
    
    public void serialize(CreateBulkPrescriptionOutput createBulkPrescriptionOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPrescriptionOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPrescriptionOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPrescriptionOutput);
		sb.append(']');
	}
	
}
