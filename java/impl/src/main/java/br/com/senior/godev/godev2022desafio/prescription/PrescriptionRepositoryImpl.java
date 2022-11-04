package br.com.senior.godev.godev2022desafio.prescription;
import br.com.senior.godev.godev2022desafio.PrescriptionEntity;
import br.com.senior.godev.godev2022desafio.QDoctorEntity;
import br.com.senior.godev.godev2022desafio.QPrescriptionEntity;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

 class PrescriptionRepositoryImpl implements PrescriptionRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<PrescriptionEntity> getPrescriptionForDoctor(String name) {

        QDoctorEntity doctorEntity = QDoctorEntity.doctorEntity;
        QPrescriptionEntity prescriptionEntity = QPrescriptionEntity.prescriptionEntity;

        return new JPAQuery<>(entityManager)//
                .select(prescriptionEntity)
                .from(doctorEntity)
                .innerJoin(doctorEntity.prescriptions, prescriptionEntity)
                .where(doctorEntity.name.containsIgnoreCase(name))
                .fetch();
    }

}

