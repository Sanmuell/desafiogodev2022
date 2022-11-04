package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPrescriptionInputStringSerializer {
    
	public static final ExportPrescriptionInputStringSerializer INSTANCE = new ExportPrescriptionInputStringSerializer();
    
    public void serialize(ExportPrescriptionInput exportPrescriptionInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPrescriptionInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPrescriptionInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPrescriptionInput);
		serializeConfig(exportPrescriptionInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportPrescriptionInput exportPrescriptionInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportPrescriptionInput.config == null) {
			sb.append("null");
		} else {
			exportPrescriptionInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
