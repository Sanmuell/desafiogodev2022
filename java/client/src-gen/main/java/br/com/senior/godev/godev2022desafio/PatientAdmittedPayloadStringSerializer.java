package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PatientAdmittedPayloadStringSerializer {
    
	public static final PatientAdmittedPayloadStringSerializer INSTANCE = new PatientAdmittedPayloadStringSerializer();
    
    public void serialize(PatientAdmittedPayload patientAdmittedPayload, StringBuilder sb, List<Object> appended) {
		sb.append(patientAdmittedPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(patientAdmittedPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(patientAdmittedPayload);
		serializeId(patientAdmittedPayload, sb);
		sb.append(", ");
		serializeName(patientAdmittedPayload, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(PatientAdmittedPayload patientAdmittedPayload, StringBuilder sb) {
		sb.append("id=").append(patientAdmittedPayload.id == null ? "null" : patientAdmittedPayload.id);
	}
	
	protected void serializeName(PatientAdmittedPayload patientAdmittedPayload, StringBuilder sb) {
		sb.append("name=").append(patientAdmittedPayload.name == null ? "null" : patientAdmittedPayload.name);
	}
}
