/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importPrescription", kind=CommandKind.Action, requestPrimitive="importPrescription", responsePrimitive="importPrescriptionResponse")
public interface ImportPrescription extends MessageHandler {
    
    public ImportPrescriptionOutput importPrescription(ImportPrescriptionInput request);
    
}
