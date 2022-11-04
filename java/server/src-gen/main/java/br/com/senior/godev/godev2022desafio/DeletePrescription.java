/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Prescription entity.
 */
@CommandDescription(name="deletePrescription", kind=CommandKind.Delete, requestPrimitive="deletePrescription", responsePrimitive="deletePrescriptionResponse")
public interface DeletePrescription extends MessageHandler {
    
    public void deletePrescription(Prescription.Id id);
    
}
