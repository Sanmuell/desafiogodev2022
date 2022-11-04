import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ParticipanteListComponent } from "~features/participante/views/list/participante-list.component";
import { ParticipanteFormComponent } from "~features/participante/views/form/participante-form.component";
import { ParticipanteService } from "~core/entities/participante/participante.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class ParticipanteFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("participante").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class ParticipanteFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022.participante_form_title");
    }
}

@Injectable()
export class ParticipanteFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022.participante_list_title");
    }
}

@Injectable()
export class ParticipanteFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class ParticipanteFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class ParticipanteFeatureRoutingEntityResolver {
    constructor(private participanteService: ParticipanteService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.participante === "new") return;

        return this.participanteService.get(route.params.participante);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "participante",
        component: EmptyComponent,
        canActivate: [
            ParticipanteFeatureRoutingGuard,
            /*{CA:PARTICIPANTE_ROUTE_GUARDS:START}*/
            /*{CA:PARTICIPANTE_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: ParticipanteFeatureRoutingPermissionResolver,
            localeConfig: ParticipanteFeatureRoutingLocaleResolver,
            routeTitle: ParticipanteFeatureRoutingListTitleResolver,
            /*{CA:PARTICIPANTE_ROUTE_RESOLVE:START}*/
            /*{CA:PARTICIPANTE_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: ParticipanteListComponent,
            },
            {
                path: ":participante",
                component: EmptyComponent,
                canActivate: [ParticipanteFeatureRoutingGuard],
                resolve: {
                    routeTitle: ParticipanteFeatureRoutingFormTitleResolver,
                    entity: ParticipanteFeatureRoutingEntityResolver,
                    /*{CA:PARTICIPANTE_ROUTE_RESOLVE:START}*/
                    /*{CA:PARTICIPANTE_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: ParticipanteFormComponent,
                    },

                    /*{CA:PARTICIPANTE_ROUTE_CHILDREN:START}*/
                    /*{CA:PARTICIPANTE_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:PARTICIPANTE_ROUTE_CHILDREN:START}*/
            /*{CA:PARTICIPANTE_ROUTE_CHILDREN:END}*/
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
        ParticipanteFeatureRoutingGuard,
        ParticipanteFeatureRoutingPermissionResolver,
        ParticipanteFeatureRoutingLocaleResolver,
        ParticipanteFeatureRoutingFormTitleResolver,
        ParticipanteFeatureRoutingListTitleResolver,
        ParticipanteFeatureRoutingEntityResolver,
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
export class ParticipanteFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
