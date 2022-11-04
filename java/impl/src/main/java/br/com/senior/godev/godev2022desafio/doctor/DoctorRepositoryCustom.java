package br.com.senior.godev.godev2022desafio.doctor;

import br.com.senior.godev.godev2022desafio.DoctorEntity;

import java.util.List;

interface DoctorRepositoryCustom {

    List<DoctorEntity> getDoctorBySpecialityName(String speciality);


}
