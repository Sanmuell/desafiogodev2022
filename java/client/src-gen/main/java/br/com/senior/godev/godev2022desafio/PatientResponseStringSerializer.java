package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PatientResponseStringSerializer {
    
	public static final PatientResponseStringSerializer INSTANCE = new PatientResponseStringSerializer();
    
    public void serialize(PatientResponse patientResponse, StringBuilder sb, List<Object> appended) {
		sb.append(patientResponse.getClass().getSimpleName()).append(" [");
		if (appended.contains(patientResponse)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(patientResponse);
		serializeName(patientResponse, sb);
		sb.append(", ");
		serializeIsAtivo(patientResponse, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeName(PatientResponse patientResponse, StringBuilder sb) {
		sb.append("name=").append(patientResponse.name == null ? "null" : patientResponse.name);
	}
	
	protected void serializeIsAtivo(PatientResponse patientResponse, StringBuilder sb) {
		sb.append("isAtivo=").append(patientResponse.isAtivo == null ? "null" : patientResponse.isAtivo);
	}
}
