package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportResponsibleFamilyMemberEventPayloadStringSerializer {
    
	public static final ImportResponsibleFamilyMemberEventPayloadStringSerializer INSTANCE = new ImportResponsibleFamilyMemberEventPayloadStringSerializer();
    
    public void serialize(ImportResponsibleFamilyMemberEventPayload importResponsibleFamilyMemberEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importResponsibleFamilyMemberEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importResponsibleFamilyMemberEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importResponsibleFamilyMemberEventPayload);
		serializeEventpl(importResponsibleFamilyMemberEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportResponsibleFamilyMemberEventPayload importResponsibleFamilyMemberEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importResponsibleFamilyMemberEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importResponsibleFamilyMemberEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
