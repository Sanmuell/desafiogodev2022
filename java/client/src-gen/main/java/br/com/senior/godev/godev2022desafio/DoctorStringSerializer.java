package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class DoctorStringSerializer {
    
	public static final DoctorStringSerializer INSTANCE = new DoctorStringSerializer();
    
    public void serialize(Doctor doctor, StringBuilder sb, List<Object> appended) {
		sb.append(doctor.getClass().getSimpleName()).append(" [");
		if (appended.contains(doctor)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(doctor);
		serializeId(doctor, sb);
		sb.append(", ");
		serializeName(doctor, sb);
		sb.append(", ");
		serializeCpf(doctor, sb);
		sb.append(", ");
		serializeCrmNumber(doctor, sb);
		sb.append(", ");
		serializeCrmState(doctor, sb);
		sb.append(", ");
		serializeEspeciality(doctor, sb);
		sb.append(", ");
		serializePrescriptions(doctor, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Doctor doctor, StringBuilder sb) {
		sb.append("id=").append(doctor.id == null ? "null" : doctor.id);
	}
	
	protected void serializeName(Doctor doctor, StringBuilder sb) {
		sb.append("name=").append(doctor.name == null ? "null" : doctor.name);
	}
	
	protected void serializeCpf(Doctor doctor, StringBuilder sb) {
		sb.append("cpf=").append(doctor.cpf == null ? "null" : doctor.cpf);
	}
	
	protected void serializeCrmNumber(Doctor doctor, StringBuilder sb) {
		sb.append("crmNumber=").append(doctor.crmNumber == null ? "null" : doctor.crmNumber);
	}
	
	protected void serializeCrmState(Doctor doctor, StringBuilder sb) {
		sb.append("crmState=").append(doctor.crmState == null ? "null" : doctor.crmState);
	}
	
	protected void serializeEspeciality(Doctor doctor, StringBuilder sb) {
		sb.append("especiality=").append(doctor.especiality == null ? "null" : doctor.especiality);
	}
	
	protected void serializePrescriptions(Doctor doctor, StringBuilder sb, List<Object> appended) {
		sb.append("prescriptions=<");
		if (doctor.prescriptions == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = doctor.prescriptions.size() - 1;
			for (int i = 0; i <= last; i++) {
				doctor.prescriptions.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
