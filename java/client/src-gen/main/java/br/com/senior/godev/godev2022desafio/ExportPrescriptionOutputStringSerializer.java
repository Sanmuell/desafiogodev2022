package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPrescriptionOutputStringSerializer {
    
	public static final ExportPrescriptionOutputStringSerializer INSTANCE = new ExportPrescriptionOutputStringSerializer();
    
    public void serialize(ExportPrescriptionOutput exportPrescriptionOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPrescriptionOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPrescriptionOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPrescriptionOutput);
		serializeExportJobId(exportPrescriptionOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportPrescriptionOutput exportPrescriptionOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportPrescriptionOutput.exportJobId == null ? "null" : exportPrescriptionOutput.exportJobId);
	}
}
