/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the Patient entity.
 */
@CommandDescription(name="updateMergePatient", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergePatient", responsePrimitive="updateMergePatientResponse")
public interface UpdateMergePatient extends MessageHandler {
    
    public Patient updateMergePatient(Patient toUpdateMerge);
    
}
