package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportDoctorInputStringSerializer {
    
	public static final ExportDoctorInputStringSerializer INSTANCE = new ExportDoctorInputStringSerializer();
    
    public void serialize(ExportDoctorInput exportDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportDoctorInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportDoctorInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportDoctorInput);
		serializeConfig(exportDoctorInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportDoctorInput exportDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportDoctorInput.config == null) {
			sb.append("null");
		} else {
			exportDoctorInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
