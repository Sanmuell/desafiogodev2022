package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportDoctorInputStringSerializer {
    
	public static final ImportDoctorInputStringSerializer INSTANCE = new ImportDoctorInputStringSerializer();
    
    public void serialize(ImportDoctorInput importDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append(importDoctorInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importDoctorInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importDoctorInput);
		serializeConfig(importDoctorInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportDoctorInput importDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importDoctorInput.config == null) {
			sb.append("null");
		} else {
			importDoctorInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
