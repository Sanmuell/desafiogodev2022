/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class DoctorEntityStringSerializer {
	
	public static final DoctorEntityStringSerializer INSTANCE = new DoctorEntityStringSerializer();
    
    public void serialize(DoctorEntity doctor, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(DoctorEntity doctor, StringBuilder sb) {
		sb.append("id=").append(doctor.getId() == null ? "null" : doctor.getId());
	}
	
	protected void serializeName(DoctorEntity doctor, StringBuilder sb) {
		sb.append("name=").append(doctor.getName() == null ? "null" : doctor.getName());
	}
	
	protected void serializeCpf(DoctorEntity doctor, StringBuilder sb) {
		sb.append("cpf=").append(doctor.getCpf() == null ? "null" : doctor.getCpf());
	}
	
	protected void serializeCrmNumber(DoctorEntity doctor, StringBuilder sb) {
		sb.append("crmNumber=").append(doctor.getCrmNumber() == null ? "null" : doctor.getCrmNumber());
	}
	
	protected void serializeCrmState(DoctorEntity doctor, StringBuilder sb) {
		sb.append("crmState=").append(doctor.getCrmState() == null ? "null" : doctor.getCrmState());
	}
	
	protected void serializeEspeciality(DoctorEntity doctor, StringBuilder sb) {
		sb.append("especiality=").append(doctor.getEspeciality() == null ? "null" : doctor.getEspeciality());
	}
	
	protected void serializePrescriptions(DoctorEntity doctor, StringBuilder sb, List<Object> appended) {
		sb.append("prescriptions=<");
		if (doctor.getPrescriptions() == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = doctor.getPrescriptions().size() - 1;
			int i = 0;
			for (PrescriptionEntity item : doctor.getPrescriptions()) {
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
}
