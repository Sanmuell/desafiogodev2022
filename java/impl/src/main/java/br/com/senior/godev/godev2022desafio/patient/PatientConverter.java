package br.com.senior.godev.godev2022desafio.patient;

import br.com.senior.godev.godev2022desafio.PatientEntity;
import br.com.senior.godev.godev2022desafio.PatientResponse;
import org.springframework.stereotype.Service;

@Service
public class PatientConverter {


    public PatientResponse toRecord(PatientEntity entity) {
        final PatientResponse patientResponse = new PatientResponse();
        patientResponse.name = entity.getName();
        patientResponse.isAtivo = entity.getIsAtivo();

        return patientResponse;

    }
}