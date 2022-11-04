package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPatientEventPayloadStringSerializer {
    
	public static final ExportPatientEventPayloadStringSerializer INSTANCE = new ExportPatientEventPayloadStringSerializer();
    
    public void serialize(ExportPatientEventPayload exportPatientEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportPatientEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPatientEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPatientEventPayload);
		serializeEventpl(exportPatientEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportPatientEventPayload exportPatientEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportPatientEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportPatientEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
