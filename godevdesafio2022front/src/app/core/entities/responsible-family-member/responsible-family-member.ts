/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ResponsibleFamilyMemberDto } from "~core/entities/responsible-family-member/responsible-family-member-dto";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class ResponsibleFamilyMember {
    public id?: string;
    public name: string;
    public cpf: string;
    public kinship?: string;
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(responsibleFamilyMemberDto: ResponsibleFamilyMemberDto, originEntity?: string): ResponsibleFamilyMember {
        const model: any = { ...responsibleFamilyMemberDto };

        const lookupSeparator = " - ";
        const displayFields = ["id", "name", "cpf", "kinship"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        return model as ResponsibleFamilyMember;
    }

    public static toDto(responsibleFamilyMember: ResponsibleFamilyMember, originEntity?: string): ResponsibleFamilyMemberDto {
        const dto: any = { ...responsibleFamilyMember };

        delete dto.label;

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
