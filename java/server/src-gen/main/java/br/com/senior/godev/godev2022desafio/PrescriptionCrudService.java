/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;
import br.com.senior.godev.godev2022desafio.Prescription.Id;
import br.com.senior.messaging.customspringdata.EntityInfo;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface PrescriptionCrudService extends CrudService<PrescriptionEntity> {
	
	public PrescriptionEntity createPrescription(PrescriptionEntity toCreate);
	
	@Deprecated
	public PrescriptionEntity createMergePrescription(PrescriptionEntity toCreateMerge);
	
	public PrescriptionEntity updatePrescription(PrescriptionEntity toUpdate);
	
	@Deprecated
	public PrescriptionEntity updateMergePrescription(PrescriptionEntity toUpdateMerge);
	
	public void deletePrescription(Id id);
	
	public PrescriptionEntity retrievePrescription(Id id);
	
	@Deprecated
	public List<PrescriptionEntity> listPrescription(int skip, int top);
	
	public Page<PrescriptionEntity> listPrescriptionPageable(int skip, int top);
	
	public Page<PrescriptionEntity> listPrescriptionPageable(int skip, int top, String orderBy);
	
	public Page<PrescriptionEntity> listPrescriptionPageable(int skip, int top, String orderBy, String filter);
	
	public Page<PrescriptionEntity> listPrescriptionPageable(int skip, int top, String orderBy, String filter, EntityInfo parentEntity);
	
	public void createBulkPrescription(List<PrescriptionEntity> entities);

	public PrescriptionBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
