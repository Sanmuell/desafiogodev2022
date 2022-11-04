package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportDoctorEventPayloadStringSerializer {
    
	public static final ExportDoctorEventPayloadStringSerializer INSTANCE = new ExportDoctorEventPayloadStringSerializer();
    
    public void serialize(ExportDoctorEventPayload exportDoctorEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportDoctorEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportDoctorEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportDoctorEventPayload);
		serializeEventpl(exportDoctorEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportDoctorEventPayload exportDoctorEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportDoctorEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportDoctorEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
