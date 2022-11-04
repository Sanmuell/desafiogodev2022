/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Doctor entity.
 */
@CommandDescription(name="createDoctor", kind=CommandKind.Create, requestPrimitive="createDoctor", responsePrimitive="createDoctorResponse")
public interface CreateDoctor extends MessageHandler {
    
    public Doctor createDoctor(Doctor toCreate);
    
}
