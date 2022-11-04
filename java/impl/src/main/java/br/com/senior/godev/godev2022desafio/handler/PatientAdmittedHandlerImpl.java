package br.com.senior.godev.godev2022desafio.handler;

import br.com.senior.godev.godev2022desafio.PatientAdmitted;
import br.com.senior.godev.godev2022desafio.PatientAdmittedPayload;
import br.com.senior.messaging.model.HandlerImpl;
import org.springframework.transaction.annotation.Transactional;

@HandlerImpl
public class PatientAdmittedHandlerImpl implements PatientAdmitted {

    @Override
    @Transactional
    public void patientAdmitted(PatientAdmittedPayload payload) {
        System.out.println("Evento ***PatientAdmitted*** consumido --- PACIENTE: " + payload.id + "  " + payload.name);
    }
}
