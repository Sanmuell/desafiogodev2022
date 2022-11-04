package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkPatientOutputStringSerializer {
    
	public static final CreateBulkPatientOutputStringSerializer INSTANCE = new CreateBulkPatientOutputStringSerializer();
    
    public void serialize(CreateBulkPatientOutput createBulkPatientOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPatientOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPatientOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPatientOutput);
		sb.append(']');
	}
	
}
