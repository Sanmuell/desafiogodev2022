/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.List;
import br.com.senior.godev.godev2022desafio.ResponsibleFamilyMember.Id;
import br.com.senior.messaging.customspringdata.EntityInfo;
import br.com.senior.springbatchintegration.importer.CrudService;
import br.com.senior.messaging.customspringdata.CustomOrder;
import java.util.Set;
import br.com.senior.messaging.customspringdata.Join;
import org.springframework.data.domain.Page;

public interface ResponsibleFamilyMemberCrudService extends CrudService<ResponsibleFamilyMemberEntity> {
	
	public ResponsibleFamilyMemberEntity createResponsibleFamilyMember(ResponsibleFamilyMemberEntity toCreate);
	
	@Deprecated
	public ResponsibleFamilyMemberEntity createMergeResponsibleFamilyMember(ResponsibleFamilyMemberEntity toCreateMerge);
	
	public ResponsibleFamilyMemberEntity updateResponsibleFamilyMember(ResponsibleFamilyMemberEntity toUpdate);
	
	@Deprecated
	public ResponsibleFamilyMemberEntity updateMergeResponsibleFamilyMember(ResponsibleFamilyMemberEntity toUpdateMerge);
	
	public void deleteResponsibleFamilyMember(Id id);
	
	public ResponsibleFamilyMemberEntity retrieveResponsibleFamilyMember(Id id);
	
	@Deprecated
	public List<ResponsibleFamilyMemberEntity> listResponsibleFamilyMember(int skip, int top);
	
	public Page<ResponsibleFamilyMemberEntity> listResponsibleFamilyMemberPageable(int skip, int top);
	
	public Page<ResponsibleFamilyMemberEntity> listResponsibleFamilyMemberPageable(int skip, int top, String orderBy);
	
	public Page<ResponsibleFamilyMemberEntity> listResponsibleFamilyMemberPageable(int skip, int top, String orderBy, String filter);
	
	public Page<ResponsibleFamilyMemberEntity> listResponsibleFamilyMemberPageable(int skip, int top, String orderBy, String filter, EntityInfo parentEntity);
	
	public void createBulkResponsibleFamilyMember(List<ResponsibleFamilyMemberEntity> entities);

	public ResponsibleFamilyMemberBaseRepository getRepository();
	
	public void validateFilterColumns(Set<String> columns, List<Join> joinFields, String lastPath);
	
	public void validateCustomOrders(List<CustomOrder> customOrders);
	
}
