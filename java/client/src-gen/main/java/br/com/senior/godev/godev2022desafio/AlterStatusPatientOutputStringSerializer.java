package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class AlterStatusPatientOutputStringSerializer {
    
	public static final AlterStatusPatientOutputStringSerializer INSTANCE = new AlterStatusPatientOutputStringSerializer();
    
    public void serialize(AlterStatusPatientOutput alterStatusPatientOutput, StringBuilder sb, List<Object> appended) {
		sb.append(alterStatusPatientOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(alterStatusPatientOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(alterStatusPatientOutput);
		serializePatient(alterStatusPatientOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializePatient(AlterStatusPatientOutput alterStatusPatientOutput, StringBuilder sb, List<Object> appended) {
		sb.append("patient=<");
		if (alterStatusPatientOutput.patient == null) {
			sb.append("null");
		} else {
			alterStatusPatientOutput.patient.toString(sb, appended);
		}
		sb.append('>');
	}
}
