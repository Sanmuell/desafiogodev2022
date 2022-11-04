package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPrescriptionInputStringSerializer {
    
	public static final ImportPrescriptionInputStringSerializer INSTANCE = new ImportPrescriptionInputStringSerializer();
    
    public void serialize(ImportPrescriptionInput importPrescriptionInput, StringBuilder sb, List<Object> appended) {
		sb.append(importPrescriptionInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPrescriptionInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPrescriptionInput);
		serializeConfig(importPrescriptionInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportPrescriptionInput importPrescriptionInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importPrescriptionInput.config == null) {
			sb.append("null");
		} else {
			importPrescriptionInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
