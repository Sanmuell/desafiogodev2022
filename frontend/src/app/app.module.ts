import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, PreloadAllModules } from "@angular/router";
import { ToastModule } from "primeng/toast";
import { HotkeyModule } from "angular2-hotkeys";
import { MessageService } from "primeng/api";
import {
    LocaleModule,
    BreadcrumbModule,
    LoadingStateModule,
    ProductHeaderModule,
    AngularComponentsModule,
} from "@seniorsistemas/angular-components";
import { of } from "rxjs";
import {
    TranslationsModule,
    PermissionsModule,
    HttpInterceptorModule,
    RestUrl,
    FeatureToggleModule,
} from "@seniorsistemas/platform-components";
import { TranslateModule } from "@ngx-translate/core";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/
import * as fallback from "src/locale/pt-BR.json";
import { fallback as fallbackTs } from "src/locale/fallback";
import { environment } from "~environments/environment";
import { CoreModule } from "~core/core.module";
import { FeaturesModule } from "~features/features.module";
import { AppComponent } from "~app/app.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export const translations = environment.production ? fallbackTs : fallback;

export class CustomRestUrl {
    get() {
        return of(environment.restUrl);
    }
}

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot([], { paramsInheritanceStrategy: "always", preloadingStrategy: PreloadAllModules, useHash: true }),
        HttpClientModule,
        HttpInterceptorModule,
        LocaleModule.forRoot(),
        PermissionsModule.forRoot([], { ignorePermissions: environment.ignorePermissions }),
        BreadcrumbModule,
        ToastModule,
        LoadingStateModule,
        HotkeyModule.forRoot(),
        ProductHeaderModule,
        FeatureToggleModule,
        TranslateModule.forRoot(),
        TranslationsModule.forRoot([
            {
                domain: "godev",
                service: "godev2022",
                fallback: translations.default ? translations.default : translations,
            },
        ]),
        AngularComponentsModule.forRoot({
            domain: "godev",
            service: "godev2022",
        }),
        FeaturesModule,
        CoreModule,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        AppComponent,
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    providers: [
        MessageService,
        { provide: RestUrl, useFactory: () => (!environment.production && environment.restUrl ? new CustomRestUrl() : new RestUrl()) },
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    bootstrap: [AppComponent],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class AppModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
