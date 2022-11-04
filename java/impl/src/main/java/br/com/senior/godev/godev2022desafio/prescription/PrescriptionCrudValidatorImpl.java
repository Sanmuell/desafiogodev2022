package br.com.senior.godev.godev2022desafio.prescription;

import br.com.senior.godev.godev2022desafio.PrecriptionType;
import br.com.senior.godev.godev2022desafio.Prescription;
import br.com.senior.godev.godev2022desafio.PrescriptionCrudValidator;
import br.com.senior.godev.godev2022desafio.PrescriptionEntity;
import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PrescriptionCrudValidatorImpl implements PrescriptionCrudValidator {

    @Inject
    private TranslationHubApi translationHubApi;
    @Override
    public void beforeCreate(PrescriptionEntity entity) {
        if (entity.getType().equals(PrecriptionType.WHITE) && entity.getStatementOfReponsability().equals(false)){
            throw new ServiceException(ErrorCategory.BAD_REQUEST, //
                    translationHubApi.getMessage("br.com.senior.godev.godev2022desafio.precription_missing_responsability_term"));
        }
    }

    @Override
    public void beforeUpdate(PrescriptionEntity entity) {

    }

    @Override
    public void beforeDelete(Prescription.Id id) {

    }
}
