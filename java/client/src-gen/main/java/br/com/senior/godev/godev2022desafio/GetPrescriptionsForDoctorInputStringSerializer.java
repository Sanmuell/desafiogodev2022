package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class GetPrescriptionsForDoctorInputStringSerializer {
    
	public static final GetPrescriptionsForDoctorInputStringSerializer INSTANCE = new GetPrescriptionsForDoctorInputStringSerializer();
    
    public void serialize(GetPrescriptionsForDoctorInput getPrescriptionsForDoctorInput, StringBuilder sb, List<Object> appended) {
		sb.append(getPrescriptionsForDoctorInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getPrescriptionsForDoctorInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getPrescriptionsForDoctorInput);
		serializeName(getPrescriptionsForDoctorInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeName(GetPrescriptionsForDoctorInput getPrescriptionsForDoctorInput, StringBuilder sb) {
		sb.append("name=").append(getPrescriptionsForDoctorInput.name == null ? "null" : getPrescriptionsForDoctorInput.name);
	}
}
