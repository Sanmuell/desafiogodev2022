package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPatientOutputStringSerializer {
    
	public static final ImportPatientOutputStringSerializer INSTANCE = new ImportPatientOutputStringSerializer();
    
    public void serialize(ImportPatientOutput importPatientOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importPatientOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPatientOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPatientOutput);
		serializeImportJobId(importPatientOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportPatientOutput importPatientOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importPatientOutput.importJobId == null ? "null" : importPatientOutput.importJobId);
	}
}
