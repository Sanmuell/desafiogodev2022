/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { DoctorDto } from "~core/entities/doctor/doctor-dto";
import { Prescription } from "~core/entities/prescription/prescription";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Doctor {
    public id?: string;
    public name: string;
    public cpf: string;
    public crmNumber: number;
    public crmState: string;
    public especiality: string;
    public prescriptions?: Prescription[];
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(doctorDto: DoctorDto, originEntity?: string): Doctor {
        const model: any = { ...doctorDto };

        const lookupSeparator = " - ";
        const displayFields = ["id", "name", "cpf", "crmNumber", "crmState", "especiality"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        if (originEntity !== "Prescription" && model.prescriptions)
            model.prescriptions = Object.values(model.prescriptions).map((item: any) => Prescription.fromDto(item, "Doctor"));

        return model as Doctor;
    }

    public static toDto(doctor: Doctor, originEntity?: string): DoctorDto {
        const dto: any = { ...doctor };

        delete dto.label;

        if (originEntity !== "Prescription" && dto.prescriptions)
            dto.prescriptions = Object.values(dto.prescriptions)
                .map((item: any) => Prescription.toDto(item, "Doctor"))
                .filter(item => Object.keys(item).length);

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
