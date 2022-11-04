/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="listResponsibleFamilyMember", kind=CommandKind.List, requestPrimitive="listResponsibleFamilyMember", responsePrimitive="listResponsibleFamilyMemberResponse")
public interface ListResponsibleFamilyMember extends MessageHandler {
    
    public ResponsibleFamilyMember.PagedResults listResponsibleFamilyMember(ResponsibleFamilyMember.PageRequest pageRequest);
    
}
