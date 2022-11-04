/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportPatient", kind=CommandKind.Query, requestPrimitive="exportPatient", responsePrimitive="exportPatientResponse")
public interface ExportPatient extends MessageHandler {
    
    public ExportPatientOutput exportPatient(ExportPatientInput request);
    
}
