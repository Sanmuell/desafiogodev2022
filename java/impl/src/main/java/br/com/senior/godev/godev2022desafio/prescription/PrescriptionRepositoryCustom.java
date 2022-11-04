package br.com.senior.godev.godev2022desafio.prescription;

import br.com.senior.godev.godev2022desafio.PrescriptionEntity;

import java.util.List;

interface PrescriptionRepositoryCustom {

    List<PrescriptionEntity> getPrescriptionForDoctor(String name);
}
