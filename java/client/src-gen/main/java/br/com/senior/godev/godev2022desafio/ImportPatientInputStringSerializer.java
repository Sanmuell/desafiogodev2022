package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPatientInputStringSerializer {
    
	public static final ImportPatientInputStringSerializer INSTANCE = new ImportPatientInputStringSerializer();
    
    public void serialize(ImportPatientInput importPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append(importPatientInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPatientInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPatientInput);
		serializeConfig(importPatientInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportPatientInput importPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importPatientInput.config == null) {
			sb.append("null");
		} else {
			importPatientInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
