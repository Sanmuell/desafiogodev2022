/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Prescription entity.
 */
@CommandDescription(name="updatePrescription", kind=CommandKind.Update, requestPrimitive="updatePrescription", responsePrimitive="updatePrescriptionResponse")
public interface UpdatePrescription extends MessageHandler {
    
    public Prescription updatePrescription(Prescription toUpdate);
    
}
