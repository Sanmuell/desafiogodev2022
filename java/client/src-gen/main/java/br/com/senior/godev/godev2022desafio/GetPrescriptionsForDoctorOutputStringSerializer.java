package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class GetPrescriptionsForDoctorOutputStringSerializer {
    
	public static final GetPrescriptionsForDoctorOutputStringSerializer INSTANCE = new GetPrescriptionsForDoctorOutputStringSerializer();
    
    public void serialize(GetPrescriptionsForDoctorOutput getPrescriptionsForDoctorOutput, StringBuilder sb, List<Object> appended) {
		sb.append(getPrescriptionsForDoctorOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getPrescriptionsForDoctorOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getPrescriptionsForDoctorOutput);
		serializePrescription(getPrescriptionsForDoctorOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializePrescription(GetPrescriptionsForDoctorOutput getPrescriptionsForDoctorOutput, StringBuilder sb, List<Object> appended) {
		sb.append("prescription=<");
		if (getPrescriptionsForDoctorOutput.prescription == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = getPrescriptionsForDoctorOutput.prescription.size() - 1;
			for (int i = 0; i <= last; i++) {
				getPrescriptionsForDoctorOutput.prescription.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
