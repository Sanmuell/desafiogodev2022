/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Prescription entity.
 */
@CommandDescription(name="createPrescription", kind=CommandKind.Create, requestPrimitive="createPrescription", responsePrimitive="createPrescriptionResponse")
public interface CreatePrescription extends MessageHandler {
    
    public Prescription createPrescription(Prescription toCreate);
    
}
