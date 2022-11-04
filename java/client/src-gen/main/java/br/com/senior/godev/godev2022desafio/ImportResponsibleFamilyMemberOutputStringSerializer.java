package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ImportResponsibleFamilyMemberOutputStringSerializer {
    
	public static final ImportResponsibleFamilyMemberOutputStringSerializer INSTANCE = new ImportResponsibleFamilyMemberOutputStringSerializer();
    
    public void serialize(ImportResponsibleFamilyMemberOutput importResponsibleFamilyMemberOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importResponsibleFamilyMemberOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importResponsibleFamilyMemberOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importResponsibleFamilyMemberOutput);
		serializeImportJobId(importResponsibleFamilyMemberOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportResponsibleFamilyMemberOutput importResponsibleFamilyMemberOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importResponsibleFamilyMemberOutput.importJobId == null ? "null" : importResponsibleFamilyMemberOutput.importJobId);
	}
}
