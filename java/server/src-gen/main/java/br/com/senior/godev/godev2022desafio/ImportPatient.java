/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importPatient", kind=CommandKind.Action, requestPrimitive="importPatient", responsePrimitive="importPatientResponse")
public interface ImportPatient extends MessageHandler {
    
    public ImportPatientOutput importPatient(ImportPatientInput request);
    
}
