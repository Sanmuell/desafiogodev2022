/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkPrescription", kind = CommandKind.Create, requestPrimitive = "createBulkPrescription", responsePrimitive="")
public interface CreateBulkPrescription extends MessageHandler {
    public CreateBulkPrescriptionOutput createBulkPrescription(CreateBulkPrescriptionInput toCreate);
}
