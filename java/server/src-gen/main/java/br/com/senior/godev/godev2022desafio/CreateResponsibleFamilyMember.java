/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="createResponsibleFamilyMember", kind=CommandKind.Create, requestPrimitive="createResponsibleFamilyMember", responsePrimitive="createResponsibleFamilyMemberResponse")
public interface CreateResponsibleFamilyMember extends MessageHandler {
    
    public ResponsibleFamilyMember createResponsibleFamilyMember(ResponsibleFamilyMember toCreate);
    
}
