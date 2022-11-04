package br.com.senior.godev.godev2022desafio.doctor;


import br.com.senior.godev.godev2022desafio.DoctorBaseRepository;

import org.springframework.stereotype.Repository;

@Repository
interface DoctorRepository extends DoctorBaseRepository, DoctorRepositoryCustom {

    Boolean existsByName(String name);


}
