/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importResponsibleFamilyMember", kind=CommandKind.Action, requestPrimitive="importResponsibleFamilyMember", responsePrimitive="importResponsibleFamilyMemberResponse")
public interface ImportResponsibleFamilyMember extends MessageHandler {
    
    public ImportResponsibleFamilyMemberOutput importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput request);
    
}
