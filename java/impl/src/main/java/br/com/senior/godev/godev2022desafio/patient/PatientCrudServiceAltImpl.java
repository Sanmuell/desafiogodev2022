package br.com.senior.godev.godev2022desafio.patient;

import br.com.senior.godev.godev2022desafio.*;
import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@Transactional
public class PatientCrudServiceAltImpl extends PatientCrudServiceImpl {

    @Inject
    private PatientBaseRepository patientBaseRepository;

    @Inject
    private TranslationHubApi translationHubApi;


    @Override
    public PatientEntity create(PatientEntity entity) {
        return super.create(entity);
    }

    @Override
    public PatientEntity createPatient(PatientEntity entity) {
        return super.createPatient(entity);
    }

    @Override
    public void deletePatient(Patient.Id id) {
        String patientId = id.getPatientId();

        Optional<PatientEntity> patient = patientBaseRepository.findById(UUID.fromString(patientId));

        if (patient.isEmpty()) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.patient_not_found"));
        } else if (patient.get().getIsAtivo().equals(true)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.patient_active_cannot_be_delete"));
        }
        super.deletePatient(id);


    }
}

