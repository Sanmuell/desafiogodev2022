/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the Patient entity.
 */
@CommandDescription(name="retrievePatient", kind=CommandKind.Retrieve, requestPrimitive="retrievePatient", responsePrimitive="retrievePatientResponse")
public interface RetrievePatient extends MessageHandler {
    
    public Patient retrievePatient(Patient.GetRequest id);
    
}
