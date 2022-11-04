package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkResponsibleFamilyMemberOutputStringSerializer {
    
	public static final CreateBulkResponsibleFamilyMemberOutputStringSerializer INSTANCE = new CreateBulkResponsibleFamilyMemberOutputStringSerializer();
    
    public void serialize(CreateBulkResponsibleFamilyMemberOutput createBulkResponsibleFamilyMemberOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkResponsibleFamilyMemberOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkResponsibleFamilyMemberOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkResponsibleFamilyMemberOutput);
		sb.append(']');
	}
	
}
