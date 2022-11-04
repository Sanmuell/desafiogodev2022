package br.com.senior.godev.godev2022desafio.patient;

import br.com.senior.godev.godev2022desafio.*;
import br.com.senior.messaging.BrokerException;
import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.Message;
import br.com.senior.messaging.model.ServiceContext;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.messaging.utils.DtoJsonConverter;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;


@Service
public class PatientService {

    @Inject
    private PatientRepository patientRepository;


    @Inject
    private TranslationHubApi translationHubApi;


    public PatientEntity alterStatus(UUID idPatient) {

        final Optional<PatientEntity> patientOpt = patientRepository.findById(idPatient);

        if (patientOpt.isEmpty()) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.patient_not_found"));
        } else if (patientOpt.get().getIsAtivo().equals(true)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.patient_already_active"));
        } else {
            patientOpt.get().setIsAtivo(true);
        }
        final PatientEntity patient = patientOpt.get();
        PatientEntity patientSaved = patientRepository.save(patient);

        return patientSaved;

    }

    public String patientAdmitted(String namePatientAdmitted, String idPatientAdmitted) {


        final ServiceContext serviceContext = ServiceContext.get();
        final String tenant = serviceContext.getCurrentTenant();
        final String username = serviceContext.getCurrentUsername();

        final PatientAdmittedPayload payload = new PatientAdmittedPayload();
        PatientEntity patient = new PatientEntity();

        payload.id = idPatientAdmitted;
        payload.name = namePatientAdmitted;


        final Message message = new Message(tenant, Godev2022desafioConstants.Events.PATIENT_ADMITTED, DtoJsonConverter.toJSON(payload));

        System.out.println(translationHubApi.getFormattedMessage("br.com.senior.godev.godev2022desafio.patient_admitted", idPatientAdmitted, namePatientAdmitted));

        try {
            serviceContext.getCurrentMessenger().publish(message);
        } catch (
                BrokerException e) {
            throw new RuntimeException(e);
        }

        return idPatientAdmitted;
    }


}









