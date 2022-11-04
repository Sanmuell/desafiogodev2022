/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the Patient entity.
 */
@CommandDescription(name="listPatient", kind=CommandKind.List, requestPrimitive="listPatient", responsePrimitive="listPatientResponse")
public interface ListPatient extends MessageHandler {
    
    public Patient.PagedResults listPatient(Patient.PageRequest pageRequest);
    
}
