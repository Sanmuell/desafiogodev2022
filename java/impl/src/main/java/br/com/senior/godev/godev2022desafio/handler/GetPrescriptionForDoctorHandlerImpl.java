package br.com.senior.godev.godev2022desafio.handler;


import br.com.senior.godev.godev2022desafio.GetPrescriptionsForDoctor;
import br.com.senior.godev.godev2022desafio.GetPrescriptionsForDoctorInput;
import br.com.senior.godev.godev2022desafio.GetPrescriptionsForDoctorOutput;
import br.com.senior.godev.godev2022desafio.PrescriptionEntity;
import br.com.senior.godev.godev2022desafio.prescription.PrescriptionConverter;
import br.com.senior.godev.godev2022desafio.prescription.PrescriptionService;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.security.SecureResource;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class GetPrescriptionForDoctorHandlerImpl implements GetPrescriptionsForDoctor {

    @Inject
    private PrescriptionConverter prescriptionConverter;

    @Inject
    private PrescriptionService prescriptionService;


    @Override
    @Transactional
    @SecureResource(name = PrescriptionEntity.SECURITY_RESOURCE, action = "Visualizar")
    public GetPrescriptionsForDoctorOutput getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput request) {

        final List<PrescriptionEntity> prescriptions = prescriptionService.getPrescriptionForDoctor(request.name);

        return new GetPrescriptionsForDoctorOutput(prescriptions.stream().map(prescriptionConverter::toDTO).collect(Collectors.toList()));
    }
}
