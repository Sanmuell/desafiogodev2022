/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * Evento responsável por declarar que paciente foi admitido
 */
@SubscriptionDescription(domain="godev", service="godev2022desafio", event="patientAdmitted")
public interface PatientAdmitted extends MessageHandler {
    public void patientAdmitted(PatientAdmittedPayload payload);
    
}
