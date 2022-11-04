/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="updateResponsibleFamilyMember", kind=CommandKind.Update, requestPrimitive="updateResponsibleFamilyMember", responsePrimitive="updateResponsibleFamilyMemberResponse")
public interface UpdateResponsibleFamilyMember extends MessageHandler {
    
    public ResponsibleFamilyMember updateResponsibleFamilyMember(ResponsibleFamilyMember toUpdate);
    
}
