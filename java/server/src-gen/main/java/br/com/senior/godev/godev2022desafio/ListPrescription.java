/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the Prescription entity.
 */
@CommandDescription(name="listPrescription", kind=CommandKind.List, requestPrimitive="listPrescription", responsePrimitive="listPrescriptionResponse")
public interface ListPrescription extends MessageHandler {
    
    public Prescription.PagedResults listPrescription(Prescription.PageRequest pageRequest);
    
}
