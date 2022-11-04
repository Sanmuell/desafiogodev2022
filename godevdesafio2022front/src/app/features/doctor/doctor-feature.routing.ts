import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { DoctorListComponent } from "~features/doctor/views/list/doctor-list.component";
import { DoctorFormComponent } from "~features/doctor/views/form/doctor-form.component";
import { DoctorService } from "~core/entities/doctor/doctor.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class DoctorFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("doctor").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class DoctorFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.doctor_form_title");
    }
}

@Injectable()
export class DoctorFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.doctor_list_title");
    }
}

@Injectable()
export class DoctorFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class DoctorFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class DoctorFeatureRoutingEntityResolver {
    constructor(private doctorService: DoctorService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.doctor === "new") return;

        return this.doctorService.get(route.params.doctor);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "doctor",
        component: EmptyComponent,
        canActivate: [
            DoctorFeatureRoutingGuard,
            /*{CA:DOCTOR_ROUTE_GUARDS:START}*/
            /*{CA:DOCTOR_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: DoctorFeatureRoutingPermissionResolver,
            localeConfig: DoctorFeatureRoutingLocaleResolver,
            routeTitle: DoctorFeatureRoutingListTitleResolver,
            /*{CA:DOCTOR_ROUTE_RESOLVE:START}*/
            /*{CA:DOCTOR_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: DoctorListComponent,
            },
            {
                path: ":doctor",
                component: EmptyComponent,
                canActivate: [DoctorFeatureRoutingGuard],
                resolve: {
                    routeTitle: DoctorFeatureRoutingFormTitleResolver,
                    entity: DoctorFeatureRoutingEntityResolver,
                    /*{CA:DOCTOR_ROUTE_RESOLVE:START}*/
                    /*{CA:DOCTOR_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: DoctorFormComponent,
                    },

                    /*{CA:DOCTOR_ROUTE_CHILDREN:START}*/
                    /*{CA:DOCTOR_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:DOCTOR_ROUTE_CHILDREN:START}*/
            /*{CA:DOCTOR_ROUTE_CHILDREN:END}*/
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
        DoctorFeatureRoutingGuard,
        DoctorFeatureRoutingPermissionResolver,
        DoctorFeatureRoutingLocaleResolver,
        DoctorFeatureRoutingFormTitleResolver,
        DoctorFeatureRoutingListTitleResolver,
        DoctorFeatureRoutingEntityResolver,
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
export class DoctorFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
