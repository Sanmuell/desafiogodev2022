/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the Doctor entity.
 */
@CommandDescription(name="retrieveDoctor", kind=CommandKind.Retrieve, requestPrimitive="retrieveDoctor", responsePrimitive="retrieveDoctorResponse")
public interface RetrieveDoctor extends MessageHandler {
    
    public Doctor retrieveDoctor(Doctor.GetRequest id);
    
}
