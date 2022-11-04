package br.com.senior.godev.godev2022desafio.handler;


import br.com.senior.godev.godev2022desafio.*;
import br.com.senior.godev.godev2022desafio.patient.PatientConverter;
import br.com.senior.godev.godev2022desafio.patient.PatientService;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.security.SecureResource;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.UUID;

@HandlerImpl
public class AlterStatusPatientHandlerImpl implements AlterStatusPatient {

    @Inject
    private PatientConverter patientConverter;

    @Inject
    private PatientService patientService;

    @Inject
    private TranslationHubApi translationHubApi;


    @Override
    @Transactional
    @SecureResource(name = PatientEntity.SECURITY_RESOURCE, action = "Visualizar")
    @SecureResource(name = PatientEntity.SECURITY_RESOURCE, action = "Editar")
    public AlterStatusPatientOutput alterStatusPatient(AlterStatusPatientInput request) {
        PatientEntity patient = patientService.alterStatus(UUID.fromString(request.id));
        patientService.patientAdmitted(request.id, patient.getName());

        return new AlterStatusPatientOutput(patientConverter.toRecord(patient));


    }
}
