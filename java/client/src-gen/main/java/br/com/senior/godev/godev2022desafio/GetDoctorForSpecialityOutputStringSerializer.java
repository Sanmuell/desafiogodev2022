package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class GetDoctorForSpecialityOutputStringSerializer {
    
	public static final GetDoctorForSpecialityOutputStringSerializer INSTANCE = new GetDoctorForSpecialityOutputStringSerializer();
    
    public void serialize(GetDoctorForSpecialityOutput getDoctorForSpecialityOutput, StringBuilder sb, List<Object> appended) {
		sb.append(getDoctorForSpecialityOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getDoctorForSpecialityOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getDoctorForSpecialityOutput);
		serializeDoctor(getDoctorForSpecialityOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeDoctor(GetDoctorForSpecialityOutput getDoctorForSpecialityOutput, StringBuilder sb, List<Object> appended) {
		sb.append("doctor=<");
		if (getDoctorForSpecialityOutput.doctor == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = getDoctorForSpecialityOutput.doctor.size() - 1;
			for (int i = 0; i <= last; i++) {
				getDoctorForSpecialityOutput.doctor.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
