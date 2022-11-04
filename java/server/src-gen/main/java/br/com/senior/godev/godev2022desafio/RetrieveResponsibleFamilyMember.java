/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="retrieveResponsibleFamilyMember", kind=CommandKind.Retrieve, requestPrimitive="retrieveResponsibleFamilyMember", responsePrimitive="retrieveResponsibleFamilyMemberResponse")
public interface RetrieveResponsibleFamilyMember extends MessageHandler {
    
    public ResponsibleFamilyMember retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest id);
    
}
