package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportDoctorOutputStringSerializer {
    
	public static final ImportDoctorOutputStringSerializer INSTANCE = new ImportDoctorOutputStringSerializer();
    
    public void serialize(ImportDoctorOutput importDoctorOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importDoctorOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importDoctorOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importDoctorOutput);
		serializeImportJobId(importDoctorOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportDoctorOutput importDoctorOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importDoctorOutput.importJobId == null ? "null" : importDoctorOutput.importJobId);
	}
}
