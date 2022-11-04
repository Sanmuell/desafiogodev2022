import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { HotkeyModule } from "angular2-hotkeys";
import { CurrencyMaskModule } from "ng2-currency-mask";
import { TranslateModule } from "@ngx-translate/core";
import {
    CustomFieldsModule,
    ControlErrorsModule,
    EmptyStateModule,
    DynamicFormModule,
    TokenListModule,
    LoadingStateModule,
    NumberInputModule,
    TableModule,
} from "@seniorsistemas/angular-components";
import { CyclicJsonInterceptorModule, HttpInterceptorModule } from "@seniorsistemas/platform-components";
import { PanelModule } from "primeng/panel";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { CheckboxModule } from "primeng/checkbox";
import { TableModule as PrimeTableModule } from "primeng/table";
import { ConfirmDialogModule } from "primeng/confirmdialog";
import { CalendarModule } from "primeng/calendar";
import { DropdownModule } from "primeng/dropdown";
import { TabViewModule } from "primeng/tabview";
import { SharedModule as PrimeSharedModule } from "primeng/api";
import { FiltersStorageService } from "~shared/storage/filters-storage.service";
import { PaginatorStorageService } from "~shared/storage/paginator-storage.service";
import { TabviewStorageService } from "~shared/storage/tabview-storage.service";
import { FocusService } from "~shared/focus/focus.service";
import { FieldCustomizationService } from "~shared/services/field-customization.service";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    exports: [
        FormsModule,
        ReactiveFormsModule,
        CommonModule,
        CurrencyMaskModule,
        TranslateModule,
        CustomFieldsModule,
        ControlErrorsModule,
        EmptyStateModule,
        DynamicFormModule,
        TokenListModule,
        PanelModule,
        InputTextModule,
        ButtonModule,
        CheckboxModule,
        PrimeTableModule,
        ConfirmDialogModule,
        CalendarModule,
        DropdownModule,
        TabViewModule,
        PrimeSharedModule,
        HotkeyModule,
        LoadingStateModule,
        NumberInputModule,
        CyclicJsonInterceptorModule,
        HttpInterceptorModule,
        TableModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    providers: [
        FiltersStorageService,
        PaginatorStorageService,
        TabviewStorageService,
        FocusService,
        FieldCustomizationService,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class SharedModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
