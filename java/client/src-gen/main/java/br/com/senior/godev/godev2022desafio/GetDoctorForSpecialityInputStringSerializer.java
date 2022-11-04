package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class GetDoctorForSpecialityInputStringSerializer {
    
	public static final GetDoctorForSpecialityInputStringSerializer INSTANCE = new GetDoctorForSpecialityInputStringSerializer();
    
    public void serialize(GetDoctorForSpecialityInput getDoctorForSpecialityInput, StringBuilder sb, List<Object> appended) {
		sb.append(getDoctorForSpecialityInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getDoctorForSpecialityInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getDoctorForSpecialityInput);
		serializeSpeciality(getDoctorForSpecialityInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeSpeciality(GetDoctorForSpecialityInput getDoctorForSpecialityInput, StringBuilder sb) {
		sb.append("speciality=").append(getDoctorForSpecialityInput.speciality == null ? "null" : getDoctorForSpecialityInput.speciality);
	}
}
