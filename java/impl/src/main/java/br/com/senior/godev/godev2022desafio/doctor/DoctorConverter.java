package br.com.senior.godev.godev2022desafio.doctor;

import br.com.senior.godev.godev2022desafio.Doctor;
import br.com.senior.godev.godev2022desafio.DoctorEntity;
import br.com.senior.godev.godev2022desafio.prescription.PrescriptionConverter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DoctorConverter {

    @Inject
    private PrescriptionConverter prescriptionConverter;


    public Doctor doctorSpecialityToRecord(DoctorEntity entity) {
        final Doctor doctorSpecialityToRecord = new Doctor();
        doctorSpecialityToRecord.id = String.valueOf(entity.getId());
        doctorSpecialityToRecord.name = entity.getName();
        doctorSpecialityToRecord.especiality = entity.getEspeciality();
        doctorSpecialityToRecord.crmNumber = entity.getCrmNumber();

        return doctorSpecialityToRecord;
    }

}