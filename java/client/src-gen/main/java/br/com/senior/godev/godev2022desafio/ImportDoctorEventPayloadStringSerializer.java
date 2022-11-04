package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportDoctorEventPayloadStringSerializer {
    
	public static final ImportDoctorEventPayloadStringSerializer INSTANCE = new ImportDoctorEventPayloadStringSerializer();
    
    public void serialize(ImportDoctorEventPayload importDoctorEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importDoctorEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importDoctorEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importDoctorEventPayload);
		serializeEventpl(importDoctorEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportDoctorEventPayload importDoctorEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importDoctorEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importDoctorEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
