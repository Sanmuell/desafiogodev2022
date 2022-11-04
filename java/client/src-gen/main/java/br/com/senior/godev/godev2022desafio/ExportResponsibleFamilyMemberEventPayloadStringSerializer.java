package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportResponsibleFamilyMemberEventPayloadStringSerializer {
    
	public static final ExportResponsibleFamilyMemberEventPayloadStringSerializer INSTANCE = new ExportResponsibleFamilyMemberEventPayloadStringSerializer();
    
    public void serialize(ExportResponsibleFamilyMemberEventPayload exportResponsibleFamilyMemberEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportResponsibleFamilyMemberEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportResponsibleFamilyMemberEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportResponsibleFamilyMemberEventPayload);
		serializeEventpl(exportResponsibleFamilyMemberEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportResponsibleFamilyMemberEventPayload exportResponsibleFamilyMemberEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportResponsibleFamilyMemberEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportResponsibleFamilyMemberEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
