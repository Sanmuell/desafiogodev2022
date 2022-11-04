package br.com.senior.godev.godev2022desafio.doctor;

import br.com.senior.godev.godev2022desafio.Doctor;
import br.com.senior.godev.godev2022desafio.DoctorCrudValidator;
import br.com.senior.godev.godev2022desafio.DoctorEntity;
import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DoctorCrudValidatorImpl implements DoctorCrudValidator {

    @Inject
    private DoctorService doctorService;

    @Inject
    private TranslationHubApi translationHubApi;


    @Override
    public void beforeCreate(DoctorEntity entity) {
        if (Boolean.TRUE.equals(doctorService.nameExist(entity.getName()))) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, //
                    translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.doctor_name_already_exist"));
        }

    }

    @Override
    public void beforeUpdate(DoctorEntity entity) {
        if (Boolean.TRUE.equals(doctorService.nameExist(entity.getName()))) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, //
                    translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.doctor_name_already_exist"));
        }


    }

    @Override
    public void beforeDelete(Doctor.Id id) {
        // TODO document why this method is empty
    }


}
