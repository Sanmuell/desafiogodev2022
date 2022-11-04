/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkResponsibleFamilyMember", kind = CommandKind.Create, requestPrimitive = "createBulkResponsibleFamilyMember", responsePrimitive="")
public interface CreateBulkResponsibleFamilyMember extends MessageHandler {
    public CreateBulkResponsibleFamilyMemberOutput createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput toCreate);
}
