import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/
import { MainModule } from "~features/main/main.module";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export const routes: Routes = [
    {
        path: "",
        redirectTo: "/main",
        pathMatch: "full",
    },
    {
        path: "",
        loadChildren: "~features/tarefa/tarefa-feature.module#TarefaFeatureModule",
    },
    {
        path: "",
        loadChildren: "~features/participante/participante-feature.module#ParticipanteFeatureModule",
    },
    /*{CA:FEATURE_ROUTES:START}*/
    /*{CA:FEATURE_ROUTES:END}*/
    {
        path: "**",
        redirectTo: "/not-found",
    },
];

@NgModule({
    imports: [
        MainModule,
        RouterModule.forChild(routes),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    providers: [
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    exports: [
        RouterModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class FeaturesModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
