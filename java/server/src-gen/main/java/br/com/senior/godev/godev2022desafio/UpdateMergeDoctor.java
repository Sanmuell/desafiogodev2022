/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the Doctor entity.
 */
@CommandDescription(name="updateMergeDoctor", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergeDoctor", responsePrimitive="updateMergeDoctorResponse")
public interface UpdateMergeDoctor extends MessageHandler {
    
    public Doctor updateMergeDoctor(Doctor toUpdateMerge);
    
}
