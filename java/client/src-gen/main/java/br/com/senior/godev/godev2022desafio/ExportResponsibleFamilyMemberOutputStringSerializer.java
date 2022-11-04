package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ExportResponsibleFamilyMemberOutputStringSerializer {
    
	public static final ExportResponsibleFamilyMemberOutputStringSerializer INSTANCE = new ExportResponsibleFamilyMemberOutputStringSerializer();
    
    public void serialize(ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMemberOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportResponsibleFamilyMemberOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportResponsibleFamilyMemberOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportResponsibleFamilyMemberOutput);
		serializeExportJobId(exportResponsibleFamilyMemberOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMemberOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportResponsibleFamilyMemberOutput.exportJobId == null ? "null" : exportResponsibleFamilyMemberOutput.exportJobId);
	}
}
