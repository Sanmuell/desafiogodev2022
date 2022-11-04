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
import java.util.Optional;
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="godev.godev2022desafio.DoctorEntity")
@ODataEntity(id = "doctor")
@Table(name="doctor")
public class DoctorEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/godev/godev2022desafio/entities/doctor";

	/**
	 * Id do medico
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Nome do medico
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Cpf do medico
	 */
	@Column(name = "cpf")
	private String cpf;
	
	/**
	 * CRM do medico
	 */
	@Column(name = "crm_number")
	private Long crmNumber;
	
	/**
	 * Estado do CRM do medico
	 */
	@Column(name = "crm_state")
	private String crmState;
	
	@Column(name = "especiality")
	private String especiality;
	
	/**
	 * Prescrições
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorResponsible")
	private java.util.List<PrescriptionEntity> prescriptions = new ArrayList<>();
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "doctor";
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
	
	public Long getCrmNumber() {
		return crmNumber;
	}
	
	public String getCrmState() {
		return crmState;
	}
	
	public String getEspeciality() {
		return especiality;
	}
	
	public java.util.List<PrescriptionEntity> getPrescriptions() {
		return prescriptions;
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
	
	public void setCrmNumber(Long crmNumber) {
		this.crmNumber = crmNumber;
	}
	
	public void setCrmState(String crmState) {
		this.crmState = crmState;
	}
	
	public void setEspeciality(String especiality) {
		this.especiality = especiality;
	}
	
	public void setPrescriptions(List<PrescriptionEntity> prescriptions) {
		if (prescriptions != null) {
			prescriptions.forEach(this::addToPrescriptions);
		} else {
			final List<PrescriptionEntity> current = new ArrayList<PrescriptionEntity>();
			current.addAll(this.prescriptions);
			current.forEach(this::removeFromPrescriptions);
		}
	}
	
	public void addToPrescriptions(PrescriptionEntity prescriptionEntity) {
		if (prescriptionEntity.getId() == null || !prescriptions.contains(prescriptionEntity)) {
			prescriptions.add(prescriptionEntity);
			prescriptionEntity.setDoctorResponsible(this);
		} else {
			//required for merge operations
			prescriptions.remove(prescriptions.indexOf(prescriptionEntity));
			prescriptions.add(prescriptionEntity);
			prescriptionEntity.setDoctorResponsible(this);
		}
	}
	
	public PrescriptionEntity getFromPrescriptions(java.util.UUID prescriptionEntityId) {
		Optional<PrescriptionEntity> entity = prescriptions.stream().filter(e -> e.getId().equals(prescriptionEntityId)).findFirst();
		if (entity.isPresent()) {
			return entity.get();
		}
		return null;
	}
	
	public void removeFromPrescriptions(PrescriptionEntity prescriptionEntity) {
		prescriptions.remove(prescriptionEntity);
		prescriptionEntity.setDoctorResponsible(null);
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
	    if (!(obj instanceof DoctorEntity)) {
	        return false;
	    }
	    DoctorEntity other = (DoctorEntity) obj;
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
		DoctorEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
