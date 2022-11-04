package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportResponsibleFamilyMemberInputStringSerializer {
    
	public static final ExportResponsibleFamilyMemberInputStringSerializer INSTANCE = new ExportResponsibleFamilyMemberInputStringSerializer();
    
    public void serialize(ExportResponsibleFamilyMemberInput exportResponsibleFamilyMemberInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportResponsibleFamilyMemberInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportResponsibleFamilyMemberInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportResponsibleFamilyMemberInput);
		serializeConfig(exportResponsibleFamilyMemberInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportResponsibleFamilyMemberInput exportResponsibleFamilyMemberInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportResponsibleFamilyMemberInput.config == null) {
			sb.append("null");
		} else {
			exportResponsibleFamilyMemberInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
