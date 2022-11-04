package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ResponsibleFamilyMemberStringSerializer {
    
	public static final ResponsibleFamilyMemberStringSerializer INSTANCE = new ResponsibleFamilyMemberStringSerializer();
    
    public void serialize(ResponsibleFamilyMember responsibleFamilyMember, StringBuilder sb, List<Object> appended) {
		sb.append(responsibleFamilyMember.getClass().getSimpleName()).append(" [");
		if (appended.contains(responsibleFamilyMember)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(responsibleFamilyMember);
		serializeId(responsibleFamilyMember, sb);
		sb.append(", ");
		serializeName(responsibleFamilyMember, sb);
		sb.append(", ");
		serializeCpf(responsibleFamilyMember, sb);
		sb.append(", ");
		serializeKinship(responsibleFamilyMember, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(ResponsibleFamilyMember responsibleFamilyMember, StringBuilder sb) {
		sb.append("id=").append(responsibleFamilyMember.id == null ? "null" : responsibleFamilyMember.id);
	}
	
	protected void serializeName(ResponsibleFamilyMember responsibleFamilyMember, StringBuilder sb) {
		sb.append("name=").append(responsibleFamilyMember.name == null ? "null" : responsibleFamilyMember.name);
	}
	
	protected void serializeCpf(ResponsibleFamilyMember responsibleFamilyMember, StringBuilder sb) {
		sb.append("cpf=").append(responsibleFamilyMember.cpf == null ? "null" : responsibleFamilyMember.cpf);
	}
	
	protected void serializeKinship(ResponsibleFamilyMember responsibleFamilyMember, StringBuilder sb) {
		sb.append("kinship=").append(responsibleFamilyMember.kinship == null ? "null" : responsibleFamilyMember.kinship);
	}
}
