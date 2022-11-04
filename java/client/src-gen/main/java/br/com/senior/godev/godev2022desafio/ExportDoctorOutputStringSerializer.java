package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportDoctorOutputStringSerializer {
    
	public static final ExportDoctorOutputStringSerializer INSTANCE = new ExportDoctorOutputStringSerializer();
    
    public void serialize(ExportDoctorOutput exportDoctorOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportDoctorOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportDoctorOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportDoctorOutput);
		serializeExportJobId(exportDoctorOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportDoctorOutput exportDoctorOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportDoctorOutput.exportJobId == null ? "null" : exportDoctorOutput.exportJobId);
	}
}
