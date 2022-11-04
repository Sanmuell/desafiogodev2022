package br.com.senior.godev.godev2022desafio.doctor;

import br.com.senior.godev.godev2022desafio.DoctorEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class DoctorService {

    @Inject
    private DoctorRepository doctorRepository;

    public List<DoctorEntity> getDoctorBySpeciality(String speciality) {
        return doctorRepository.getDoctorBySpecialityName(speciality);
    }

    public Boolean nameExist(String name) {
        return doctorRepository.existsByName(name);
    }


}
