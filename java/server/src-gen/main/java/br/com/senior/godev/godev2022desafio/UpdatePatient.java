/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Patient entity.
 */
@CommandDescription(name="updatePatient", kind=CommandKind.Update, requestPrimitive="updatePatient", responsePrimitive="updatePatientResponse")
public interface UpdatePatient extends MessageHandler {
    
    public Patient updatePatient(Patient toUpdate);
    
}
