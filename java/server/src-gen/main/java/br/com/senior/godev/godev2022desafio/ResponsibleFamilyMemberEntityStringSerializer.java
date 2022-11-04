/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class ResponsibleFamilyMemberEntityStringSerializer {
	
	public static final ResponsibleFamilyMemberEntityStringSerializer INSTANCE = new ResponsibleFamilyMemberEntityStringSerializer();
    
    public void serialize(ResponsibleFamilyMemberEntity responsibleFamilyMember, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(ResponsibleFamilyMemberEntity responsibleFamilyMember, StringBuilder sb) {
		sb.append("id=").append(responsibleFamilyMember.getId() == null ? "null" : responsibleFamilyMember.getId());
	}
	
	protected void serializeName(ResponsibleFamilyMemberEntity responsibleFamilyMember, StringBuilder sb) {
		sb.append("name=").append(responsibleFamilyMember.getName() == null ? "null" : responsibleFamilyMember.getName());
	}
	
	protected void serializeCpf(ResponsibleFamilyMemberEntity responsibleFamilyMember, StringBuilder sb) {
		sb.append("cpf=").append(responsibleFamilyMember.getCpf() == null ? "null" : responsibleFamilyMember.getCpf());
	}
	
	protected void serializeKinship(ResponsibleFamilyMemberEntity responsibleFamilyMember, StringBuilder sb) {
		sb.append("kinship=").append(responsibleFamilyMember.getKinship() == null ? "null" : responsibleFamilyMember.getKinship());
	}
}
