/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;
import br.com.senior.godev.godev2022desafio.Patient.Id;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface PatientCrudService extends CrudService<PatientEntity> {
	
	public PatientEntity createPatient(PatientEntity toCreate);
	
	@Deprecated
	public PatientEntity createMergePatient(PatientEntity toCreateMerge);
	
	public PatientEntity updatePatient(PatientEntity toUpdate);
	
	@Deprecated
	public PatientEntity updateMergePatient(PatientEntity toUpdateMerge);
	
	public void deletePatient(Id id);
	
	public PatientEntity retrievePatient(Id id);
	
	@Deprecated
	public List<PatientEntity> listPatient(int skip, int top);
	
	public Page<PatientEntity> listPatientPageable(int skip, int top);
	
	public Page<PatientEntity> listPatientPageable(int skip, int top, String orderBy);
	
	public Page<PatientEntity> listPatientPageable(int skip, int top, String orderBy, String filter);
	
	public void createBulkPatient(List<PatientEntity> entities);

	public PatientBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
