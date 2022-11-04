package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class AlterStatusPatientInputStringSerializer {
    
	public static final AlterStatusPatientInputStringSerializer INSTANCE = new AlterStatusPatientInputStringSerializer();
    
    public void serialize(AlterStatusPatientInput alterStatusPatientInput, StringBuilder sb, List<Object> appended) {
		sb.append(alterStatusPatientInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(alterStatusPatientInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(alterStatusPatientInput);
		serializeId(alterStatusPatientInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(AlterStatusPatientInput alterStatusPatientInput, StringBuilder sb) {
		sb.append("id=").append(alterStatusPatientInput.id == null ? "null" : alterStatusPatientInput.id);
	}
}
