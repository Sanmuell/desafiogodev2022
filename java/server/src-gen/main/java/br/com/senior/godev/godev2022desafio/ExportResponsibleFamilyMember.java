/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportResponsibleFamilyMember", kind=CommandKind.Query, requestPrimitive="exportResponsibleFamilyMember", responsePrimitive="exportResponsibleFamilyMemberResponse")
public interface ExportResponsibleFamilyMember extends MessageHandler {
    
    public ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput request);
    
}
