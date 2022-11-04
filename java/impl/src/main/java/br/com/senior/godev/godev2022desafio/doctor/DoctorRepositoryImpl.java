package br.com.senior.godev.godev2022desafio.doctor;

import br.com.senior.godev.godev2022desafio.DoctorEntity;
import br.com.senior.godev.godev2022desafio.QDoctorEntity;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

class DoctorRepositoryImpl implements DoctorRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<DoctorEntity> getDoctorBySpecialityName(String speciality) {
        QDoctorEntity doctorEntity = QDoctorEntity.doctorEntity;

        return new JPAQuery<>(entityManager)//
                .select(doctorEntity)
                .from(doctorEntity)
                .where(doctorEntity.especiality.containsIgnoreCase(speciality))
                .fetch();
    }
}
