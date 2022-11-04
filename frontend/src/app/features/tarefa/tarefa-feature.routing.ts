import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { TarefaListComponent } from "~features/tarefa/views/list/tarefa-list.component";
import { TarefaFormComponent } from "~features/tarefa/views/form/tarefa-form.component";
import { TarefaService } from "~core/entities/tarefa/tarefa.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class TarefaFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("tarefa").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class TarefaFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022.tarefa_form_title");
    }
}

@Injectable()
export class TarefaFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022.tarefa_list_title");
    }
}

@Injectable()
export class TarefaFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class TarefaFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class TarefaFeatureRoutingEntityResolver {
    constructor(private tarefaService: TarefaService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.tarefa === "new") return;

        return this.tarefaService.get(route.params.tarefa);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "tarefa",
        component: EmptyComponent,
        canActivate: [
            TarefaFeatureRoutingGuard,
            /*{CA:TAREFA_ROUTE_GUARDS:START}*/
            /*{CA:TAREFA_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: TarefaFeatureRoutingPermissionResolver,
            localeConfig: TarefaFeatureRoutingLocaleResolver,
            routeTitle: TarefaFeatureRoutingListTitleResolver,
            /*{CA:TAREFA_ROUTE_RESOLVE:START}*/
            /*{CA:TAREFA_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: TarefaListComponent,
            },
            {
                path: ":tarefa",
                component: EmptyComponent,
                canActivate: [TarefaFeatureRoutingGuard],
                resolve: {
                    routeTitle: TarefaFeatureRoutingFormTitleResolver,
                    entity: TarefaFeatureRoutingEntityResolver,
                    /*{CA:TAREFA_ROUTE_RESOLVE:START}*/
                    /*{CA:TAREFA_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: TarefaFormComponent,
                    },

                    /*{CA:TAREFA_ROUTE_CHILDREN:START}*/
                    /*{CA:TAREFA_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:TAREFA_ROUTE_CHILDREN:START}*/
            /*{CA:TAREFA_ROUTE_CHILDREN:END}*/
        ],
    },
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    exports: [
        RouterModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    providers: [
        TarefaFeatureRoutingGuard,
        TarefaFeatureRoutingPermissionResolver,
        TarefaFeatureRoutingLocaleResolver,
        TarefaFeatureRoutingFormTitleResolver,
        TarefaFeatureRoutingListTitleResolver,
        TarefaFeatureRoutingEntityResolver,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        EmptyComponent,
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class TarefaFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
