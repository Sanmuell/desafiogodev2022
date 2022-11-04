/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Patient entity.
 */
@CommandDescription(name="deletePatient", kind=CommandKind.Delete, requestPrimitive="deletePatient", responsePrimitive="deletePatientResponse")
public interface DeletePatient extends MessageHandler {
    
    public void deletePatient(Patient.Id id);
    
}
