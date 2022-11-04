package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPatientEventPayloadStringSerializer {
    
	public static final ImportPatientEventPayloadStringSerializer INSTANCE = new ImportPatientEventPayloadStringSerializer();
    
    public void serialize(ImportPatientEventPayload importPatientEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importPatientEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPatientEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPatientEventPayload);
		serializeEventpl(importPatientEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportPatientEventPayload importPatientEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importPatientEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importPatientEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
