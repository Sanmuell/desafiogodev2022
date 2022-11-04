/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="deleteResponsibleFamilyMember", kind=CommandKind.Delete, requestPrimitive="deleteResponsibleFamilyMember", responsePrimitive="deleteResponsibleFamilyMemberResponse")
public interface DeleteResponsibleFamilyMember extends MessageHandler {
    
    public void deleteResponsibleFamilyMember(ResponsibleFamilyMember.Id id);
    
}
