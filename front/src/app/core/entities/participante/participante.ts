/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ParticipanteDto } from "~core/entities/participante/participante-dto";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Participante {
    public id?: string;
    public nome: string;
    public idade: number;
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(participanteDto: ParticipanteDto, originEntity?: string): Participante {
        const model: any = { ...participanteDto };

        const lookupSeparator = " - ";
        const displayFields = ["id", "nome", "idade"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        return model as Participante;
    }

    public static toDto(participante: Participante, originEntity?: string): ParticipanteDto {
        const dto: any = { ...participante };

        delete dto.label;

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
