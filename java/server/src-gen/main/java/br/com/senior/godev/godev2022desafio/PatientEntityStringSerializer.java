/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PatientEntityStringSerializer {
	
	public static final PatientEntityStringSerializer INSTANCE = new PatientEntityStringSerializer();
    
    public void serialize(PatientEntity patient, StringBuilder sb, List<Object> appended) {
		sb.append(patient.getClass().getSimpleName()).append(" [");
		if (appended.contains(patient)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(patient);
		serializeId(patient, sb);
		sb.append(", ");
		serializeName(patient, sb);
		sb.append(", ");
		serializeCpf(patient, sb);
		sb.append(", ");
		serializeAddress(patient, sb);
		sb.append(", ");
		serializePhone(patient, sb);
		sb.append(", ");
		serializeResponsibleDoctors(patient, sb, appended);
		sb.append(", ");
		serializeResponsibleFamilyMembers(patient, sb, appended);
		sb.append(", ");
		serializePrescriptions(patient, sb, appended);
		sb.append(", ");
		serializeIsAtivo(patient, sb);
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(PatientEntity patient, StringBuilder sb) {
		sb.append("id=").append(patient.getId() == null ? "null" : patient.getId());
	}
	
	protected void serializeName(PatientEntity patient, StringBuilder sb) {
		sb.append("name=").append(patient.getName() == null ? "null" : patient.getName());
	}
	
	protected void serializeCpf(PatientEntity patient, StringBuilder sb) {
		sb.append("cpf=").append(patient.getCpf() == null ? "null" : patient.getCpf());
	}
	
	protected void serializeAddress(PatientEntity patient, StringBuilder sb) {
		sb.append("address=").append(patient.getAddress() == null ? "null" : patient.getAddress());
	}
	
	protected void serializePhone(PatientEntity patient, StringBuilder sb) {
		sb.append("phone=").append(patient.getPhone() == null ? "null" : patient.getPhone());
	}
	
	protected void serializeResponsibleDoctors(PatientEntity patient, StringBuilder sb, List<Object> appended) {
		sb.append("responsibleDoctors=<");
		if (patient.getResponsibleDoctors() == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.getResponsibleDoctors().size() - 1;
			int i = 0;
			for (DoctorEntity item : patient.getResponsibleDoctors()) {
				item.toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
				i++;
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializeResponsibleFamilyMembers(PatientEntity patient, StringBuilder sb, List<Object> appended) {
		sb.append("responsibleFamilyMembers=<");
		if (patient.getResponsibleFamilyMembers() == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.getResponsibleFamilyMembers().size() - 1;
			int i = 0;
			for (ResponsibleFamilyMemberEntity item : patient.getResponsibleFamilyMembers()) {
				item.toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
				i++;
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializePrescriptions(PatientEntity patient, StringBuilder sb, List<Object> appended) {
		sb.append("prescriptions=<");
		if (patient.getPrescriptions() == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.getPrescriptions().size() - 1;
			int i = 0;
			for (PrescriptionEntity item : patient.getPrescriptions()) {
				item.toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
				i++;
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializeIsAtivo(PatientEntity patient, StringBuilder sb) {
		sb.append("isAtivo=").append(patient.getIsAtivo() == null ? "null" : patient.getIsAtivo());
	}
}
