/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { TarefaDto } from "~core/entities/tarefa/tarefa-dto";
import { Participante } from "~core/entities/participante/participante";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Tarefa {
    public id?: string;
    public descricao: string;
    public participantes?: Participante[];
    public custom?: any;
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(tarefaDto: TarefaDto, originEntity?: string): Tarefa {
        const model: any = { ...tarefaDto };

        const lookupSeparator = " - ";
        const displayFields = ["id", "descricao"];

        model.label = displayFields.map(field => model[field]).join(lookupSeparator);

        if (originEntity !== "Participante" && model.participantes)
            model.participantes = Object.values(model.participantes).map((item: any) => Participante.fromDto(item, "Tarefa"));

        return model as Tarefa;
    }

    public static toDto(tarefa: Tarefa, originEntity?: string): TarefaDto {
        const dto: any = { ...tarefa };

        delete dto.label;

        if (originEntity !== "Participante" && dto.participantes)
            dto.participantes = Object.values(dto.participantes)
                .map((item: any) => Participante.toDto(item, "Tarefa"))
                .filter(item => Object.keys(item).length);

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
