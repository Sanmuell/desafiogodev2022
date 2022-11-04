/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Prescription entity.
 */
@CommandDescription(name="createMergePrescription", kind=CommandKind.CreateMerge, requestPrimitive="createMergePrescription", responsePrimitive="createMergePrescriptionResponse")
public interface CreateMergePrescription extends MessageHandler {
    
    public Prescription createMergePrescription(Prescription toCreateMerge);
    
}
