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
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="godev.godev2022desafio.ResponsibleFamilyMemberEntity")
@ODataEntity(id = "responsibleFamilyMember")
@Table(name="responsible_family_member")
public class ResponsibleFamilyMemberEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/godev/godev2022desafio/entities/responsibleFamilyMember";

	/**
	 * Id do Familiar Responsável
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Nome do Responsável
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Cpf do responsável
	 */
	@Column(name = "cpf")
	private String cpf;
	
	/**
	 * Grau de parentesco
	 */
	@Column(name = "kinship")
	private String kinship;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "responsibleFamilyMember";
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
	
	public String getKinship() {
		return kinship;
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
	
	public void setKinship(String kinship) {
		this.kinship = kinship;
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
	    if (!(obj instanceof ResponsibleFamilyMemberEntity)) {
	        return false;
	    }
	    ResponsibleFamilyMemberEntity other = (ResponsibleFamilyMemberEntity) obj;
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
		ResponsibleFamilyMemberEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
