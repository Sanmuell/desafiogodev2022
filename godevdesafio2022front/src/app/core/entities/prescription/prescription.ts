import * as moment from "moment";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { PrescriptionDto } from "~core/entities/prescription/prescription-dto";
import { Doctor } from "~core/entities/doctor/doctor";
import { Patient } from "~core/entities/patient/patient";
import { PrecriptionType } from "~core/enums/precription-type";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Prescription {
    public id?: string;
    public drug: string;
    public description: string;
    public data: Date;
    public doctorResponsible?: Doctor;
    public type: PrecriptionType;
    public statementOfReponsability?: boolean = false;
    public patient?: Patient;
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(prescriptionDto: PrescriptionDto, originEntity?: string): Prescription {
        const model: any = { ...prescriptionDto };

        model.data = model.data && moment(model.data).toDate();

        const lookupSeparator = " - ";
        const displayFields = ["id", "drug", "description", "data", "type", "statementOfReponsability"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        if (originEntity !== "Doctor" && model.doctorResponsible)
            model.doctorResponsible = Doctor.fromDto(model.doctorResponsible, "Prescription");
        if (originEntity !== "Patient" && model.patient) model.patient = Patient.fromDto(model.patient, "Prescription");

        return model as Prescription;
    }

    public static toDto(prescription: Prescription, originEntity?: string): PrescriptionDto {
        const dto: any = { ...prescription };

        dto.data = dto.data && moment(dto.data).format("YYYY-MM-DD");

        delete dto.label;

        if (originEntity !== "Doctor" && dto.doctorResponsible) dto.doctorResponsible = Doctor.toDto(dto.doctorResponsible, "Prescription");
        if (originEntity !== "Patient" && dto.patient) dto.patient = Patient.toDto(dto.patient, "Prescription");

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
