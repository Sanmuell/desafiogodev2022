/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * Responsável por obter prescrições por nome do médico
 */
@CommandDescription(name="getPrescriptionsForDoctor", kind=CommandKind.Query, requestPrimitive="getPrescriptionsForDoctor", responsePrimitive="getPrescriptionsForDoctorResponse")
public interface GetPrescriptionsForDoctor extends MessageHandler {
    
    public GetPrescriptionsForDoctorOutput getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput request);
    
}
