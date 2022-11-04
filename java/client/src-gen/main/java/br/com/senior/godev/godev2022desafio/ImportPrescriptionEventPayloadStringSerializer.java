package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportPrescriptionEventPayloadStringSerializer {
    
	public static final ImportPrescriptionEventPayloadStringSerializer INSTANCE = new ImportPrescriptionEventPayloadStringSerializer();
    
    public void serialize(ImportPrescriptionEventPayload importPrescriptionEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importPrescriptionEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPrescriptionEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPrescriptionEventPayload);
		serializeEventpl(importPrescriptionEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportPrescriptionEventPayload importPrescriptionEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importPrescriptionEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importPrescriptionEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
