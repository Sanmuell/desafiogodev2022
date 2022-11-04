/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * Responsável por obter Médicos por especialidade
 */
@CommandDescription(name="getDoctorForSpeciality", kind=CommandKind.Query, requestPrimitive="getDoctorForSpeciality", responsePrimitive="getDoctorForSpecialityResponse")
public interface GetDoctorForSpeciality extends MessageHandler {
    
    public GetDoctorForSpecialityOutput getDoctorForSpeciality(GetDoctorForSpecialityInput request);
    
}
