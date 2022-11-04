/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Doctor entity.
 */
@CommandDescription(name="createMergeDoctor", kind=CommandKind.CreateMerge, requestPrimitive="createMergeDoctor", responsePrimitive="createMergeDoctorResponse")
public interface CreateMergeDoctor extends MessageHandler {
    
    public Doctor createMergeDoctor(Doctor toCreateMerge);
    
}
