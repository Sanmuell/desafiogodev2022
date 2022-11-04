import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { PrescriptionListComponent } from "~features/prescription/views/list/prescription-list.component";
import { PrescriptionFormComponent } from "~features/prescription/views/form/prescription-form.component";
import { PrescriptionService } from "~core/entities/prescription/prescription.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class PrescriptionFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("prescription").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class PrescriptionFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.prescription_form_title");
    }
}

@Injectable()
export class PrescriptionFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.prescription_list_title");
    }
}

@Injectable()
export class PrescriptionFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class PrescriptionFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class PrescriptionFeatureRoutingEntityResolver {
    constructor(private prescriptionService: PrescriptionService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.prescription === "new") return;

        return this.prescriptionService.get(route.params.prescription);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "prescription",
        component: EmptyComponent,
        canActivate: [
            PrescriptionFeatureRoutingGuard,
            /*{CA:PRESCRIPTION_ROUTE_GUARDS:START}*/
            /*{CA:PRESCRIPTION_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: PrescriptionFeatureRoutingPermissionResolver,
            localeConfig: PrescriptionFeatureRoutingLocaleResolver,
            routeTitle: PrescriptionFeatureRoutingListTitleResolver,
            /*{CA:PRESCRIPTION_ROUTE_RESOLVE:START}*/
            /*{CA:PRESCRIPTION_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: PrescriptionListComponent,
            },
            {
                path: ":prescription",
                component: EmptyComponent,
                canActivate: [PrescriptionFeatureRoutingGuard],
                resolve: {
                    routeTitle: PrescriptionFeatureRoutingFormTitleResolver,
                    entity: PrescriptionFeatureRoutingEntityResolver,
                    /*{CA:PRESCRIPTION_ROUTE_RESOLVE:START}*/
                    /*{CA:PRESCRIPTION_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: PrescriptionFormComponent,
                    },

                    /*{CA:PRESCRIPTION_ROUTE_CHILDREN:START}*/
                    /*{CA:PRESCRIPTION_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:PRESCRIPTION_ROUTE_CHILDREN:START}*/
            /*{CA:PRESCRIPTION_ROUTE_CHILDREN:END}*/
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
        PrescriptionFeatureRoutingGuard,
        PrescriptionFeatureRoutingPermissionResolver,
        PrescriptionFeatureRoutingLocaleResolver,
        PrescriptionFeatureRoutingFormTitleResolver,
        PrescriptionFeatureRoutingListTitleResolver,
        PrescriptionFeatureRoutingEntityResolver,
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
export class PrescriptionFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
