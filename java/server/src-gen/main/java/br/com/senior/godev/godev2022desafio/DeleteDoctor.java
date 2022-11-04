/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Doctor entity.
 */
@CommandDescription(name="deleteDoctor", kind=CommandKind.Delete, requestPrimitive="deleteDoctor", responsePrimitive="deleteDoctorResponse")
public interface DeleteDoctor extends MessageHandler {
    
    public void deleteDoctor(Doctor.Id id);
    
}
