/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Patient entity.
 */
@CommandDescription(name="createPatient", kind=CommandKind.Create, requestPrimitive="createPatient", responsePrimitive="createPatientResponse")
public interface CreatePatient extends MessageHandler {
    
    public Patient createPatient(Patient toCreate);
    
}
