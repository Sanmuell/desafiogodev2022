package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class CreateBulkResponsibleFamilyMemberInputStringSerializer {
    
	public static final CreateBulkResponsibleFamilyMemberInputStringSerializer INSTANCE = new CreateBulkResponsibleFamilyMemberInputStringSerializer();
    
    public void serialize(CreateBulkResponsibleFamilyMemberInput createBulkResponsibleFamilyMemberInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkResponsibleFamilyMemberInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkResponsibleFamilyMemberInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkResponsibleFamilyMemberInput);
		serializeEntities(createBulkResponsibleFamilyMemberInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkResponsibleFamilyMemberInput createBulkResponsibleFamilyMemberInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkResponsibleFamilyMemberInput.entities == null ? "null" : createBulkResponsibleFamilyMemberInput.entities);
	}
}
