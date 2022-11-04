package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPatientOutputStringSerializer {
    
	public static final ExportPatientOutputStringSerializer INSTANCE = new ExportPatientOutputStringSerializer();
    
    public void serialize(ExportPatientOutput exportPatientOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPatientOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPatientOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPatientOutput);
		serializeExportJobId(exportPatientOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportPatientOutput exportPatientOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportPatientOutput.exportJobId == null ? "null" : exportPatientOutput.exportJobId);
	}
}
