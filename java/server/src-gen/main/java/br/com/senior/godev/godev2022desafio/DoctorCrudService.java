/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;
import br.com.senior.godev.godev2022desafio.Doctor.Id;
import br.com.senior.messaging.customspringdata.EntityInfo;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface DoctorCrudService extends CrudService<DoctorEntity> {
	
	public DoctorEntity createDoctor(DoctorEntity toCreate);
	
	@Deprecated
	public DoctorEntity createMergeDoctor(DoctorEntity toCreateMerge);
	
	public DoctorEntity updateDoctor(DoctorEntity toUpdate);
	
	@Deprecated
	public DoctorEntity updateMergeDoctor(DoctorEntity toUpdateMerge);
	
	public void deleteDoctor(Id id);
	
	public DoctorEntity retrieveDoctor(Id id);
	
	@Deprecated
	public List<DoctorEntity> listDoctor(int skip, int top);
	
	public Page<DoctorEntity> listDoctorPageable(int skip, int top);
	
	public Page<DoctorEntity> listDoctorPageable(int skip, int top, String orderBy);
	
	public Page<DoctorEntity> listDoctorPageable(int skip, int top, String orderBy, String filter);
	
	public Page<DoctorEntity> listDoctorPageable(int skip, int top, String orderBy, String filter, EntityInfo parentEntity);
	
	public void createBulkDoctor(List<DoctorEntity> entities);

	public DoctorBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
