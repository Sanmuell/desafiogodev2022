/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;

public class PrescriptionEntityStringSerializer {
	
	public static final PrescriptionEntityStringSerializer INSTANCE = new PrescriptionEntityStringSerializer();
    
    public void serialize(PrescriptionEntity prescription, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("id=").append(prescription.getId() == null ? "null" : prescription.getId());
	}
	
	protected void serializeDrug(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("drug=").append(prescription.getDrug() == null ? "null" : prescription.getDrug());
	}
	
	protected void serializeDescription(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("description=").append(prescription.getDescription() == null ? "null" : prescription.getDescription());
	}
	
	protected void serializeData(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("data=").append(prescription.getData() == null ? "null" : prescription.getData());
	}
	
	protected void serializeDoctorResponsible(PrescriptionEntity prescription, StringBuilder sb, List<Object> appended) {
		sb.append("doctorResponsible=<");
		if (prescription.getDoctorResponsible() == null) {
			sb.append("null");
		} else {
			prescription.getDoctorResponsible().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeType(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("type=").append(prescription.getType() == null ? "null" : prescription.getType());
	}
	
	protected void serializeStatementOfReponsability(PrescriptionEntity prescription, StringBuilder sb) {
		sb.append("statementOfReponsability=").append(prescription.getStatementOfReponsability() == null ? "null" : prescription.getStatementOfReponsability());
	}
	
	protected void serializePatient(PrescriptionEntity prescription, StringBuilder sb, List<Object> appended) {
		sb.append("patient=<");
		if (prescription.getPatient() == null) {
			sb.append("null");
		} else {
			prescription.getPatient().toString(sb, appended);
		}
		sb.append('>');
	}
}
