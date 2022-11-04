package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportPrescriptionEventPayloadStringSerializer {
    
	public static final ExportPrescriptionEventPayloadStringSerializer INSTANCE = new ExportPrescriptionEventPayloadStringSerializer();
    
    public void serialize(ExportPrescriptionEventPayload exportPrescriptionEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportPrescriptionEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPrescriptionEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPrescriptionEventPayload);
		serializeEventpl(exportPrescriptionEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportPrescriptionEventPayload exportPrescriptionEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportPrescriptionEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportPrescriptionEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
