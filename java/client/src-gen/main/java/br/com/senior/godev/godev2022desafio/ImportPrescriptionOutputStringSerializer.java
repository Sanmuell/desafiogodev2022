package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPrescriptionOutputStringSerializer {
    
	public static final ImportPrescriptionOutputStringSerializer INSTANCE = new ImportPrescriptionOutputStringSerializer();
    
    public void serialize(ImportPrescriptionOutput importPrescriptionOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importPrescriptionOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPrescriptionOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPrescriptionOutput);
		serializeImportJobId(importPrescriptionOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportPrescriptionOutput importPrescriptionOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importPrescriptionOutput.importJobId == null ? "null" : importPrescriptionOutput.importJobId);
	}
}
