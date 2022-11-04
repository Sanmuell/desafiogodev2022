/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { PatientDto } from "~core/entities/patient/patient-dto";
import { Doctor } from "~core/entities/doctor/doctor";
import { ResponsibleFamilyMember } from "~core/entities/responsible-family-member/responsible-family-member";
import { Prescription } from "~core/entities/prescription/prescription";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Patient {
    public id?: string;
    public name: string;
    public cpf?: string;
    public address: string;
    public phone: number;
    public responsibleDoctors?: Doctor[];
    public responsibleFamilyMembers?: ResponsibleFamilyMember[];
    public prescriptions?: Prescription[];
    public isAtivo?: boolean = false;
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(patientDto: PatientDto, originEntity?: string): Patient {
        const model: any = { ...patientDto };

        const lookupSeparator = " - ";
        const displayFields = ["id", "name", "cpf", "address", "phone", "isAtivo"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        if (originEntity !== "Doctor" && model.responsibleDoctors)
            model.responsibleDoctors = Object.values(model.responsibleDoctors).map((item: any) => Doctor.fromDto(item, "Patient"));
        if (originEntity !== "ResponsibleFamilyMember" && model.responsibleFamilyMembers)
            model.responsibleFamilyMembers = Object.values(model.responsibleFamilyMembers).map((item: any) =>
                ResponsibleFamilyMember.fromDto(item, "Patient")
            );
        if (originEntity !== "Prescription" && model.prescriptions)
            model.prescriptions = Object.values(model.prescriptions).map((item: any) => Prescription.fromDto(item, "Patient"));

        return model as Patient;
    }

    public static toDto(patient: Patient, originEntity?: string): PatientDto {
        const dto: any = { ...patient };

        delete dto.label;

        if (originEntity !== "Doctor" && dto.responsibleDoctors)
            dto.responsibleDoctors = Object.values(dto.responsibleDoctors)
                .map((item: any) => Doctor.toDto(item, "Patient"))
                .filter(item => Object.keys(item).length);
        if (originEntity !== "ResponsibleFamilyMember" && dto.responsibleFamilyMembers)
            dto.responsibleFamilyMembers = Object.values(dto.responsibleFamilyMembers)
                .map((item: any) => ResponsibleFamilyMember.toDto(item, "Patient"))
                .filter(item => Object.keys(item).length);
        if (originEntity !== "Prescription" && dto.prescriptions)
            dto.prescriptions = Object.values(dto.prescriptions)
                .map((item: any) => Prescription.toDto(item, "Patient"))
                .filter(item => Object.keys(item).length);

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
