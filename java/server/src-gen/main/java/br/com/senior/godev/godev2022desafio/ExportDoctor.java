/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportDoctor", kind=CommandKind.Query, requestPrimitive="exportDoctor", responsePrimitive="exportDoctorResponse")
public interface ExportDoctor extends MessageHandler {
    
    public ExportDoctorOutput exportDoctor(ExportDoctorInput request);
    
}
