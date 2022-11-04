/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import br.com.senior.custom.CustomEntity;
import br.com.senior.custom.odata.entity.ODataEntity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="godev.godev2022desafio.PrescriptionEntity")
@ODataEntity(id = "prescription")
@Table(name="prescription")
public class PrescriptionEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/godev/godev2022desafio/entities/prescription";

	/**
	 * Id da prescricao
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Medicamento
	 */
	@Column(name = "drug")
	private String drug;
	
	/**
	 * Descricao da prescricao
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * Data da prescricao
	 */
	@Column(name = "data")
	private java.time.LocalDate data;
	
	/**
	 * Medico que prescreveu
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_responsible")
	private DoctorEntity doctorResponsible;
	
	/**
	 * Tipo de prescricao
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private PrecriptionType type;
	
	/**
	 * Termo de responsabildiade
	 * 
	 */
	@Column(name = "statement_of_reponsability")
	private Boolean statementOfReponsability;
	
	/**
	 * Paciente
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient")
	private PatientEntity patient;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "prescription";
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getDrug() {
		return drug;
	}
	
	public String getDescription() {
		return description;
	}
	
	public java.time.LocalDate getData() {
		return data;
	}
	
	public DoctorEntity getDoctorResponsible() {
		return doctorResponsible;
	}
	
	public PrecriptionType getType() {
		return type;
	}
	
	public Boolean getStatementOfReponsability() {
		return statementOfReponsability;
	}
	
	public PatientEntity getPatient() {
		return patient;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setDrug(String drug) {
		this.drug = drug;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setData(java.time.LocalDate data) {
		this.data = data;
	}
	
	public void setDoctorResponsible(DoctorEntity doctorResponsible) {
		this.doctorResponsible = doctorResponsible;
	}
	
	public void setType(PrecriptionType type) {
		this.type = type;
	}
	
	public void setStatementOfReponsability(Boolean statementOfReponsability) {
		this.statementOfReponsability = statementOfReponsability;
	}
	
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	
	@Override
	public boolean isNew() {
		return _newEntity;
	}
	
	public void defineAsNewEntity() {
		this._newEntity = true;
	}
	
	@Override
	public int hashCode() {
	    int ret = 1;
	    if (id != null) {
	        ret = 31 * ret + id.hashCode();
	    }
	    return ret;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (!(obj instanceof PrescriptionEntity)) {
	        return false;
	    }
	    PrescriptionEntity other = (PrescriptionEntity) obj;
	    if (id == null) {
	        return false;
	    }
	    if ((id != null) && !id.equals(other.id)) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb, new ArrayList<>());
		return sb.toString();
	}
	
	void toString(StringBuilder sb, List<Object> appended) {
		PrescriptionEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
