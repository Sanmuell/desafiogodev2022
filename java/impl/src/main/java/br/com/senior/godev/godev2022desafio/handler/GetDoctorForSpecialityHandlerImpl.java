package br.com.senior.godev.godev2022desafio.handler;

import br.com.senior.godev.godev2022desafio.*;
import br.com.senior.godev.godev2022desafio.doctor.DoctorConverter;
import br.com.senior.godev.godev2022desafio.doctor.DoctorService;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.security.SecureResource;
import com.google.common.cache.RemovalListener;
import org.checkerframework.checker.units.qual.K;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class GetDoctorForSpecialityHandlerImpl implements GetDoctorForSpeciality {


    @Inject
    private DoctorService doctorService;

    @Inject
    private DoctorConverter doctorConverter;


    @Override
    @SecureResource(name = PatientEntity.SECURITY_RESOURCE, action = "Visualizar")
    @Transactional
    public GetDoctorForSpecialityOutput getDoctorForSpeciality(GetDoctorForSpecialityInput request) {


        List<DoctorEntity> doctors = doctorService.getDoctorBySpeciality(request.speciality);
        return new GetDoctorForSpecialityOutput(doctors.stream().map(doctorConverter::doctorSpecialityToRecord).collect(Collectors.toList()));
    }
}
