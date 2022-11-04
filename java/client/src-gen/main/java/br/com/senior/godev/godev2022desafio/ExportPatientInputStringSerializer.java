package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPatientInputStringSerializer {
    
	public static final ExportPatientInputStringSerializer INSTANCE = new ExportPatientInputStringSerializer();
    
    public void serialize(ExportPatientInput exportPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPatientInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPatientInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPatientInput);
		serializeConfig(exportPatientInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportPatientInput exportPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportPatientInput.config == null) {
			sb.append("null");
		} else {
			exportPatientInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
