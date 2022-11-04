/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importDoctor", kind=CommandKind.Action, requestPrimitive="importDoctor", responsePrimitive="importDoctorResponse")
public interface ImportDoctor extends MessageHandler {
    
    public ImportDoctorOutput importDoctor(ImportDoctorInput request);
    
}
