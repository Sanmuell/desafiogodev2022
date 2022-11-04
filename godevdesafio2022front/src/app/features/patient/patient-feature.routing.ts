import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { PatientListComponent } from "~features/patient/views/list/patient-list.component";
import { PatientFormComponent } from "~features/patient/views/form/patient-form.component";
import { PatientService } from "~core/entities/patient/patient.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class PatientFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("patient").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class PatientFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.patient_form_title");
    }
}

@Injectable()
export class PatientFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.patient_list_title");
    }
}

@Injectable()
export class PatientFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class PatientFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class PatientFeatureRoutingEntityResolver {
    constructor(private patientService: PatientService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.patient === "new") return;

        return this.patientService.get(route.params.patient);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "patient",
        component: EmptyComponent,
        canActivate: [
            PatientFeatureRoutingGuard,
            /*{CA:PATIENT_ROUTE_GUARDS:START}*/
            /*{CA:PATIENT_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: PatientFeatureRoutingPermissionResolver,
            localeConfig: PatientFeatureRoutingLocaleResolver,
            routeTitle: PatientFeatureRoutingListTitleResolver,
            /*{CA:PATIENT_ROUTE_RESOLVE:START}*/
            /*{CA:PATIENT_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: PatientListComponent,
            },
            {
                path: ":patient",
                component: EmptyComponent,
                canActivate: [PatientFeatureRoutingGuard],
                resolve: {
                    routeTitle: PatientFeatureRoutingFormTitleResolver,
                    entity: PatientFeatureRoutingEntityResolver,
                    /*{CA:PATIENT_ROUTE_RESOLVE:START}*/
                    /*{CA:PATIENT_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: PatientFormComponent,
                    },

                    /*{CA:PATIENT_ROUTE_CHILDREN:START}*/
                    /*{CA:PATIENT_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:PATIENT_ROUTE_CHILDREN:START}*/
            /*{CA:PATIENT_ROUTE_CHILDREN:END}*/
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
        PatientFeatureRoutingGuard,
        PatientFeatureRoutingPermissionResolver,
        PatientFeatureRoutingLocaleResolver,
        PatientFeatureRoutingFormTitleResolver,
        PatientFeatureRoutingListTitleResolver,
        PatientFeatureRoutingEntityResolver,
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
export class PatientFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
