/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * Responsável por alterar status do paciente para ativo
 */
@CommandDescription(name="alterStatusPatient", kind=CommandKind.Action, requestPrimitive="alterStatusPatient", responsePrimitive="alterStatusPatientResponse")
public interface AlterStatusPatient extends MessageHandler {
    
    public AlterStatusPatientOutput alterStatusPatient(AlterStatusPatientInput request);
    
}
