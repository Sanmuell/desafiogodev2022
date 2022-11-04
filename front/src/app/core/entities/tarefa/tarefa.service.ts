import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/api";
import { TranslateService } from "@ngx-translate/core";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { environment } from "~environments/environment";
import { TarefaDto } from "~core/entities/tarefa/tarefa-dto";
import { EntityService } from "~core/entities/entity-service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class TarefaService extends EntityService<TarefaDto> {
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    constructor(protected http: HttpClient, protected messageService: MessageService, protected translate: TranslateService) {
        super(
            http,
            messageService,
            `${environment.project.domain}/${environment.project.service}/entities/tarefa`,
            `${environment.project.domain}/${environment.project.service}/actions`,
            translate
        );
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
