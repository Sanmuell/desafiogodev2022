package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PrescriptionStringSerializer {
    
	public static final PrescriptionStringSerializer INSTANCE = new PrescriptionStringSerializer();
    
    public void serialize(Prescription prescription, StringBuilder sb, List<Object> appended) {
		sb.append(prescription.getClass().getSimpleName()).append(" [");
		if (appended.contains(prescription)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(prescription);
		serializeId(prescription, sb);
		sb.append(", ");
		serializeDrug(prescription, sb);
		sb.append(", ");
		serializeDescription(prescription, sb);
		sb.append(", ");
		serializeData(prescription, sb);
		sb.append(", ");
		serializeDoctorResponsible(prescription, sb, appended);
		sb.append(", ");
		serializeType(prescription, sb);
		sb.append(", ");
		serializeStatementOfReponsability(prescription, sb);
		sb.append(", ");
		serializePatient(prescription, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Prescription prescription, StringBuilder sb) {
		sb.append("id=").append(prescription.id == null ? "null" : prescription.id);
	}
	
	protected void serializeDrug(Prescription prescription, StringBuilder sb) {
		sb.append("drug=").append(prescription.drug == null ? "null" : prescription.drug);
	}
	
	protected void serializeDescription(Prescription prescription, StringBuilder sb) {
		sb.append("description=").append(prescription.description == null ? "null" : prescription.description);
	}
	
	protected void serializeData(Prescription prescription, StringBuilder sb) {
		sb.append("data=").append(prescription.data == null ? "null" : prescription.data);
	}
	
	protected void serializeDoctorResponsible(Prescription prescription, StringBuilder sb, List<Object> appended) {
		sb.append("doctorResponsible=<");
		if (prescription.doctorResponsible == null) {
			sb.append("null");
		} else {
			prescription.doctorResponsible.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeType(Prescription prescription, StringBuilder sb) {
		sb.append("type=").append(prescription.type == null ? "null" : prescription.type);
	}
	
	protected void serializeStatementOfReponsability(Prescription prescription, StringBuilder sb) {
		sb.append("statementOfReponsability=").append(prescription.statementOfReponsability == null ? "null" : prescription.statementOfReponsability);
	}
	
	protected void serializePatient(Prescription prescription, StringBuilder sb, List<Object> appended) {
		sb.append("patient=<");
		if (prescription.patient == null) {
			sb.append("null");
		} else {
			prescription.patient.toString(sb, appended);
		}
		sb.append('>');
	}
}
