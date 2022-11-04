import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { SharedModule } from "~shared/shared.module";
import { TarefaFeatureRouting } from "~features/tarefa/tarefa-feature.routing";
import { TarefaFormComponent } from "~features/tarefa/views/form/tarefa-form.component";
import { TarefaListComponent } from "~features/tarefa/views/list/tarefa-list.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        LocaleModule.forChild(),
        SharedModule,
        TarefaFeatureRouting,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        TarefaListComponent,
        TarefaFormComponent,

        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    providers: [
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    exports: [
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class TarefaFeatureModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
