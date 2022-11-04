package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PatientStringSerializer {
    
	public static final PatientStringSerializer INSTANCE = new PatientStringSerializer();
    
    public void serialize(Patient patient, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Patient patient, StringBuilder sb) {
		sb.append("id=").append(patient.id == null ? "null" : patient.id);
	}
	
	protected void serializeName(Patient patient, StringBuilder sb) {
		sb.append("name=").append(patient.name == null ? "null" : patient.name);
	}
	
	protected void serializeCpf(Patient patient, StringBuilder sb) {
		sb.append("cpf=").append(patient.cpf == null ? "null" : patient.cpf);
	}
	
	protected void serializeAddress(Patient patient, StringBuilder sb) {
		sb.append("address=").append(patient.address == null ? "null" : patient.address);
	}
	
	protected void serializePhone(Patient patient, StringBuilder sb) {
		sb.append("phone=").append(patient.phone == null ? "null" : patient.phone);
	}
	
	protected void serializeResponsibleDoctors(Patient patient, StringBuilder sb, List<Object> appended) {
		sb.append("responsibleDoctors=<");
		if (patient.responsibleDoctors == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.responsibleDoctors.size() - 1;
			for (int i = 0; i <= last; i++) {
				patient.responsibleDoctors.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializeResponsibleFamilyMembers(Patient patient, StringBuilder sb, List<Object> appended) {
		sb.append("responsibleFamilyMembers=<");
		if (patient.responsibleFamilyMembers == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.responsibleFamilyMembers.size() - 1;
			for (int i = 0; i <= last; i++) {
				patient.responsibleFamilyMembers.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializePrescriptions(Patient patient, StringBuilder sb, List<Object> appended) {
		sb.append("prescriptions=<");
		if (patient.prescriptions == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = patient.prescriptions.size() - 1;
			for (int i = 0; i <= last; i++) {
				patient.prescriptions.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializeIsAtivo(Patient patient, StringBuilder sb) {
		sb.append("isAtivo=").append(patient.isAtivo == null ? "null" : patient.isAtivo);
	}
}
