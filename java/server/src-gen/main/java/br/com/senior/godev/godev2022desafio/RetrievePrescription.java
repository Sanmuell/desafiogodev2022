/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the Prescription entity.
 */
@CommandDescription(name="retrievePrescription", kind=CommandKind.Retrieve, requestPrimitive="retrievePrescription", responsePrimitive="retrievePrescriptionResponse")
public interface RetrievePrescription extends MessageHandler {
    
    public Prescription retrievePrescription(Prescription.GetRequest id);
    
}
