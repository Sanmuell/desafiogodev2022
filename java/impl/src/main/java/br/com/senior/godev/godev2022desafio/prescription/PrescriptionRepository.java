package br.com.senior.godev.godev2022desafio.prescription;

import br.com.senior.godev.godev2022desafio.PrescriptionBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PrescriptionRepository extends PrescriptionBaseRepository, PrescriptionRepositoryCustom {
}
