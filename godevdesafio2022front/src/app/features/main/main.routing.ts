import { NgModule, Injectable } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { of } from "rxjs";
import { TranslateService } from "@ngx-translate/core";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { environment } from "~environments/environment";
import { MainComponent } from "~features/main/main.component";
import { ErrorPageComponent } from "./views/error-page/error-page.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class TitleResolver {
    public resolve() {
        return of(`${environment.name} (${environment.version})`);
    }
}

@Injectable()
export class NotFoundTranslationsResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return of({
            title: this.translate.instant("godev.godev2022desafio.error_not_found_title"),
            description: this.translate.instant("godev.godev2022desafio.error_not_found_description"),
        });
    }
}

@Injectable()
export class ForbiddenTranslationsResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return of({
            title: this.translate.instant("godev.godev2022desafio.error_forbidden_title"),
            description: this.translate.instant("godev.godev2022desafio.error_forbidden_description"),
        });
    }
}

@Injectable()
export class UnauthorizedTranslationsResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return of({
            title: this.translate.instant("godev.godev2022desafio.error_unauthorized_title"),
            description: this.translate.instant("godev.godev2022desafio.error_unauthorized_description"),
        });
    }
}

export const routes: Routes = [
    {
        path: "main",
        component: MainComponent,
        resolve: {
            routeTitle: TitleResolver,
            /*{CA:MAIN_ROUTE_RESOLVE:START}*/
            /*{CA:MAIN_ROUTE_RESOLVE:END}*/
        },
    },
    {
        path: "not-found",
        component: ErrorPageComponent,
        data: {
            errorCode: 404,
            routeTitle: "404",
        },
        resolve: {
            translations: NotFoundTranslationsResolver,
        },
    },
    {
        path: "forbidden",
        component: ErrorPageComponent,
        data: {
            errorCode: 403,
            routeTitle: "403",
        },
        resolve: {
            translations: ForbiddenTranslationsResolver,
        },
    },
    {
        path: "unauthorized",
        component: ErrorPageComponent,
        data: {
            errorCode: 401,
            routeTitle: "401",
        },
        resolve: {
            translations: UnauthorizedTranslationsResolver,
        },
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [TitleResolver, NotFoundTranslationsResolver, ForbiddenTranslationsResolver, UnauthorizedTranslationsResolver],
})
export class MainRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
