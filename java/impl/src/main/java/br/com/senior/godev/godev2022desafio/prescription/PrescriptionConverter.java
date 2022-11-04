package br.com.senior.godev.godev2022desafio.prescription;

import br.com.senior.godev.godev2022desafio.Prescription;
import br.com.senior.godev.godev2022desafio.PrescriptionEntity;
import org.springframework.stereotype.Service;


@Service
public class PrescriptionConverter {

    public Prescription toDTO(PrescriptionEntity entity) {
        final Prescription dto = new Prescription();

        dto.id = String.valueOf(entity.getId());
        dto.data = entity.getData();
        dto.description = entity.getDescription();;
        dto.drug = entity.getDrug();
        dto.statementOfReponsability = entity.getStatementOfReponsability();

        return dto;

    }
}