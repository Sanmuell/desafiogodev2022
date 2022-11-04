package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportResponsibleFamilyMemberInputStringSerializer {
    
	public static final ImportResponsibleFamilyMemberInputStringSerializer INSTANCE = new ImportResponsibleFamilyMemberInputStringSerializer();
    
    public void serialize(ImportResponsibleFamilyMemberInput importResponsibleFamilyMemberInput, StringBuilder sb, List<Object> appended) {
		sb.append(importResponsibleFamilyMemberInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importResponsibleFamilyMemberInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importResponsibleFamilyMemberInput);
		serializeConfig(importResponsibleFamilyMemberInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportResponsibleFamilyMemberInput importResponsibleFamilyMemberInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importResponsibleFamilyMemberInput.config == null) {
			sb.append("null");
		} else {
			importResponsibleFamilyMemberInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
