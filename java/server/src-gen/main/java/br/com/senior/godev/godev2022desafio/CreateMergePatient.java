/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Patient entity.
 */
@CommandDescription(name="createMergePatient", kind=CommandKind.CreateMerge, requestPrimitive="createMergePatient", responsePrimitive="createMergePatientResponse")
public interface CreateMergePatient extends MessageHandler {
    
    public Patient createMergePatient(Patient toCreateMerge);
    
}
