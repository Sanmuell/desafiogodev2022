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
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import br.com.senior.custom.CustomEntity;
import br.com.senior.custom.odata.entity.ODataEntity;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="godev.godev2022desafio.PatientEntity")
@ODataEntity(id = "patient")
@Table(name="patient")
public class PatientEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/godev/godev2022desafio/entities/patient";

	/**
	 * Id do paciente
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Nome do paciente
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * CPF do paciente
	 */
	@Column(name = "cpf")
	private String cpf;
	
	/**
	 * Endereco Paciente
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * Telefone do paciente
	 */
	@Column(name = "phone")
	private Long phone;
	
	/**
	 * Médico responsável pelo paciente
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patient_responsible_doctors",
	          joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
	          inverseJoinColumns = @JoinColumn(name = "responsible_doctors_id", referencedColumnName = "id"))
	private java.util.List<DoctorEntity> responsibleDoctors = new ArrayList<>();
	
	/**
	 * Familiar responsável pelo paciente
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patient_responsible_fam",
	          joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
	          inverseJoinColumns = @JoinColumn(name = "responsible_family_members_id", referencedColumnName = "id"))
	private java.util.List<ResponsibleFamilyMemberEntity> responsibleFamilyMembers = new ArrayList<>();
	
	/**
	 * Prescições médicas do paciente
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "patient_prescriptions",
	          joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
	          inverseJoinColumns = @JoinColumn(name = "prescriptions_id", referencedColumnName = "id"))
	private java.util.List<PrescriptionEntity> prescriptions = new ArrayList<>();
	
	/**
	 * Status do paciente
	 */
	@Column(name = "is_ativo")
	private Boolean isAtivo;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "patient";
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Long getPhone() {
		return phone;
	}
	
	public java.util.List<DoctorEntity> getResponsibleDoctors() {
		return responsibleDoctors;
	}
	
	public java.util.List<ResponsibleFamilyMemberEntity> getResponsibleFamilyMembers() {
		return responsibleFamilyMembers;
	}
	
	public java.util.List<PrescriptionEntity> getPrescriptions() {
		return prescriptions;
	}
	
	public Boolean getIsAtivo() {
		return isAtivo;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	public void setResponsibleDoctors(List<DoctorEntity> responsibleDoctors) {
		this.responsibleDoctors.clear();
		if (responsibleDoctors != null) {
			responsibleDoctors.forEach(this::addToResponsibleDoctors);
		}
	}
	
	public void addToResponsibleDoctors(DoctorEntity doctorEntity) {
		if (doctorEntity.getId() == null || !responsibleDoctors.contains(doctorEntity)) {
			responsibleDoctors.add(doctorEntity);
		}
	}
	
	public void removeFromResponsibleDoctors(DoctorEntity doctorEntity) {
		responsibleDoctors.remove(doctorEntity);
	}
	
	public void setResponsibleFamilyMembers(List<ResponsibleFamilyMemberEntity> responsibleFamilyMembers) {
		this.responsibleFamilyMembers.clear();
		if (responsibleFamilyMembers != null) {
			responsibleFamilyMembers.forEach(this::addToResponsibleFamilyMembers);
		}
	}
	
	public void addToResponsibleFamilyMembers(ResponsibleFamilyMemberEntity responsibleFamilyMemberEntity) {
		if (responsibleFamilyMemberEntity.getId() == null || !responsibleFamilyMembers.contains(responsibleFamilyMemberEntity)) {
			responsibleFamilyMembers.add(responsibleFamilyMemberEntity);
		}
	}
	
	public void removeFromResponsibleFamilyMembers(ResponsibleFamilyMemberEntity responsibleFamilyMemberEntity) {
		responsibleFamilyMembers.remove(responsibleFamilyMemberEntity);
	}
	
	public void setPrescriptions(List<PrescriptionEntity> prescriptions) {
		this.prescriptions.clear();
		if (prescriptions != null) {
			prescriptions.forEach(this::addToPrescriptions);
		}
	}
	
	public void addToPrescriptions(PrescriptionEntity prescriptionEntity) {
		if (prescriptionEntity.getId() == null || !prescriptions.contains(prescriptionEntity)) {
			prescriptions.add(prescriptionEntity);
		}
	}
	
	public void removeFromPrescriptions(PrescriptionEntity prescriptionEntity) {
		prescriptions.remove(prescriptionEntity);
	}
	
	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
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
	    if (!(obj instanceof PatientEntity)) {
	        return false;
	    }
	    PatientEntity other = (PatientEntity) obj;
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
		PatientEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
