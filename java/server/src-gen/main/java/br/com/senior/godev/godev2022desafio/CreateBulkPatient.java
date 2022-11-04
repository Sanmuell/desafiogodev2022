/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkPatient", kind = CommandKind.Create, requestPrimitive = "createBulkPatient", responsePrimitive="")
public interface CreateBulkPatient extends MessageHandler {
    public CreateBulkPatientOutput createBulkPatient(CreateBulkPatientInput toCreate);
}
