/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Doctor entity.
 */
@CommandDescription(name="updateDoctor", kind=CommandKind.Update, requestPrimitive="updateDoctor", responsePrimitive="updateDoctorResponse")
public interface UpdateDoctor extends MessageHandler {
    
    public Doctor updateDoctor(Doctor toUpdate);
    
}
