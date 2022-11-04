package br.com.senior.godev.godev2022desafio.prescription;


import br.com.senior.godev.godev2022desafio.PrescriptionEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;



@Service
public class PrescriptionService {

    @Inject
    private PrescriptionRepository prescriptionRepository;

    public List<PrescriptionEntity> getPrescriptionForDoctor(String name) {
        return prescriptionRepository.getPrescriptionForDoctor(name);

    }

}