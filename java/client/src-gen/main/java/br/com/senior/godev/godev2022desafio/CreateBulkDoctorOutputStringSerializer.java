package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkDoctorOutputStringSerializer {
    
	public static final CreateBulkDoctorOutputStringSerializer INSTANCE = new CreateBulkDoctorOutputStringSerializer();
    
    public void serialize(CreateBulkDoctorOutput createBulkDoctorOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkDoctorOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkDoctorOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkDoctorOutput);
		sb.append(']');
	}
	
}
