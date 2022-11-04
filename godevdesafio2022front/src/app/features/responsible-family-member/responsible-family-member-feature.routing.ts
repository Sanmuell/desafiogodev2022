import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ResponsibleFamilyMemberListComponent } from "~features/responsible-family-member/views/list/responsible-family-member-list.component";
import { ResponsibleFamilyMemberFormComponent } from "~features/responsible-family-member/views/form/responsible-family-member-form.component";
import { ResponsibleFamilyMemberService } from "~core/entities/responsible-family-member/responsible-family-member.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("responsibleFamilyMember").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.responsible_family_member_form_title");
    }
}

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("godev.godev2022desafio.responsible_family_member_list_title");
    }
}

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class ResponsibleFamilyMemberFeatureRoutingEntityResolver {
    constructor(private responsibleFamilyMemberService: ResponsibleFamilyMemberService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.responsibleFamilyMember === "new") return;

        return this.responsibleFamilyMemberService.get(route.params.responsibleFamilyMember);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "responsible-family-member",
        component: EmptyComponent,
        canActivate: [
            ResponsibleFamilyMemberFeatureRoutingGuard,
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_GUARDS:START}*/
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: ResponsibleFamilyMemberFeatureRoutingPermissionResolver,
            localeConfig: ResponsibleFamilyMemberFeatureRoutingLocaleResolver,
            routeTitle: ResponsibleFamilyMemberFeatureRoutingListTitleResolver,
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_RESOLVE:START}*/
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: ResponsibleFamilyMemberListComponent,
            },
            {
                path: ":responsibleFamilyMember",
                component: EmptyComponent,
                canActivate: [ResponsibleFamilyMemberFeatureRoutingGuard],
                resolve: {
                    routeTitle: ResponsibleFamilyMemberFeatureRoutingFormTitleResolver,
                    entity: ResponsibleFamilyMemberFeatureRoutingEntityResolver,
                    /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_RESOLVE:START}*/
                    /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: ResponsibleFamilyMemberFormComponent,
                    },

                    /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_CHILDREN:START}*/
                    /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_CHILDREN:START}*/
            /*{CA:RESPONSIBLE_FAMILY_MEMBER_ROUTE_CHILDREN:END}*/
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
        ResponsibleFamilyMemberFeatureRoutingGuard,
        ResponsibleFamilyMemberFeatureRoutingPermissionResolver,
        ResponsibleFamilyMemberFeatureRoutingLocaleResolver,
        ResponsibleFamilyMemberFeatureRoutingFormTitleResolver,
        ResponsibleFamilyMemberFeatureRoutingListTitleResolver,
        ResponsibleFamilyMemberFeatureRoutingEntityResolver,
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
export class ResponsibleFamilyMemberFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
