import { Component, OnInit, OnDestroy, TemplateRef, ViewChild, AfterViewInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { MessageService, ConfirmationService } from "primeng/api";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { TranslateService } from "@ngx-translate/core";
import { Subject, throwError, forkJoin, of } from "rxjs";
import { FocusService } from "~shared/focus/focus.service";
import { FieldCustomizationService } from "~shared/services/field-customization.service";

import { tap, takeUntil, catchError } from "rxjs/operators";
import { FormField, FieldType } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { Participante } from "~core/entities/participante/participante";

import { ParticipanteService } from "~core/entities/participante/participante.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./participante-form.component.html",
    styleUrls: [
        /*{CA:COMPONENT_STYLE_URLS:START}*/
        /*{CA:COMPONENT_STYLE_URLS:END}*/
    ],
    providers: [
        ConfirmationService,
        /*{CA:COMPONENT_PROVIDERS:START}*/
        /*{CA:COMPONENT_PROVIDERS:END}*/
    ],
    /*{CA:COMPONENT_CONFIG:START}*/
    /*{CA:COMPONENT_CONFIG:END}*/
})
export class ParticipanteFormComponent
    implements OnInit, OnDestroy, AfterViewInit /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public localeConfig: any = {};
    public currencyLocaleOptions: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public formFields: FormField[];
    public loading: boolean;
    public mainPanelCollapsed = false;

    @ViewChild("customTemplate", { static: false })
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFormFields", { static: false })
    public customFormFields: TemplateRef<any>;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        /*{CA:INJECTIONS:START}*/
        /*{CA:INJECTIONS:END}*/
        private participanteService: ParticipanteService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private fieldCustomization: FieldCustomizationService,
        private focusService: FocusService
    ) {
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public ngOnInit() {
        /*{CA:ON_INIT_START:START}*/
        /*{CA:ON_INIT_START:END}*/
        this.formGroup = this.getFormGroup();
        this.formFields = this.getFormFields();

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.setHotkeys();

        /*{CA:ON_INIT_END:START}*/
        /*{CA:ON_INIT_END:END}*/
    }

    public ngAfterViewInit() {
        /*{CA:ON_VIEW_INIT_START:START}*/
        /*{CA:ON_VIEW_INIT_START:END}*/
        const inputList = document.getElementsByTagName("input");
        const selectedInput = Array.from(inputList).find((f: any) => !f.disabled);
        if (selectedInput) {
            selectedInput.focus();
        }
        /*{CA:ON_VIEW_INIT_END:START}*/
        /*{CA:ON_VIEW_INIT_END:END}*/
    }

    public ngOnDestroy() {
        /*{CA:ON_DESTROY_START:START}*/
        /*{CA:ON_DESTROY_START:END}*/

        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();

        /*{CA:ON_DESTROY_END:START}*/
        /*{CA:ON_DESTROY_END:END}*/
    }

    public setHotkeys() {
        /*{CA:SET_HOTKEYS_START:START}*/
        /*{CA:SET_HOTKEYS_START:END}*/

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+x",
                () => {
                    if (this.permissions.excluir) this.onDelete();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+s",
                () => {
                    if (this.isNew() || this.permissions.editar) this.onSave();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+c",
                () => {
                    this.onCancel();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        /*{CA:SET_HOTKEYS_END:START}*/
        /*{CA:SET_HOTKEYS_END:END}*/
    }

    public isNew() {
        return this.routeParams.participante == "new";
    }

    public onRouteParamsChange(params: any) {
        /*{CA:ON_ROUTE_PARAMS_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_PARAMS_CHANGE_START:END}*/
        this.routeParams = params;
        /*{CA:ON_ROUTE_PARAMS_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_PARAMS_CHANGE_END:END}*/
    }

    public updateSuggestions(value: any) {
        /*{CA:ON_UPDATE_SUGGESTIONS_START:START}*/
        /*{CA:ON_UPDATE_SUGGESTIONS_START:END}*/
        /*{CA:ON_UPDATE_SUGGESTIONS_END:START}*/
        /*{CA:ON_UPDATE_SUGGESTIONS_END:END}*/
    }

    public onRouteDataChange(data: any) {
        /*{CA:ON_ROUTE_DATA_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_START:END}*/
        const { currencySymbol, thousandsSeparator, decimalSeparator } = data.localeConfig.number;

        this.localeConfig = data.localeConfig;
        this.currencyLocaleOptions = {
            align: "left",
            prefix: currencySymbol,
            thousands: thousandsSeparator,
            decimal: decimalSeparator,
        };
        this.permissions = data.allPermissions.participante;
        this.allPermissions = data.allPermissions;
        this.validateVisualization();
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            const value: any = Participante.fromDto(data.entity);
            this.updateSuggestions(value);
            this.formGroup.patchValue(value);
        } else {
            this.formGroup.patchValue(new Participante());
        }

        /*{CA:ON_ROUTE_DATA_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_END:END}*/
    }

    public onCancel() {
        /*{CA:ON_CANCEL_START:START}*/
        /*{CA:ON_CANCEL_START:END}*/

        this.goBack();

        /*{CA:ON_CANCEL_END:START}*/
        /*{CA:ON_CANCEL_END:END}*/
    }

    public onSendFile(filesToDelete: any, filesToCommit: any[]) {
        /*{CA:ON_SEND_FILE:START}*/
        /*{CA:ON_SEND_FILE:END}*/

        const observables: any[] = [];

        if (!this.fieldCustomization.isEmpty(filesToDelete)) {
            observables.push(this.fieldCustomization.deleteFiles(filesToDelete));
        }
        if (!this.fieldCustomization.isEmpty(filesToCommit)) {
            observables.push(this.fieldCustomization.commitFiles(filesToCommit));
        }

        if (!this.fieldCustomization.isEmpty(observables)) {
            return forkJoin(observables);
        } else {
            return of({});
        }
    }

    public onSave() {
        /*{CA:ON_SAVE_START:START}*/
        /*{CA:ON_SAVE_START:END}*/

        this.loading = true;

        if (!this.formGroup.valid) {
            this.loading = false;
            return this.validateAllFormFields(this.formGroup);
        }

        const { filesToDelete, filesToCommit } = this.fieldCustomization.getFiles(this.formGroup);

        this.getSaveObservable()
            .pipe(
                takeUntil(this.ngUnsubscribe),
                catchError((err: any) => {
                    this.loading = false;
                    return throwError(err);
                })
            )
            .subscribe(() => {
                /*{CA:ON_SAVE_START_TOP:START}*/
                /*{CA:ON_SAVE_START_TOP:END}*/

                this.onSendFile(filesToDelete, filesToCommit)
                    .pipe(
                        takeUntil(this.ngUnsubscribe),
                        catchError((err: any) => {
                            /*{CA:ON_SEND_ERROR_TOP:START}*/
                            /*{CA:ON_SEND_ERROR_BOTTOM:END}*/
                            this.loading = false;
                            /*{CA:ON_SEND_ERROR_TOP:START}*/
                            /*{CA:ON_SEND_ERROR_BOTTOM:END}*/
                            return throwError(err);
                        })
                    )
                    .subscribe(() => {
                        this.addMessage("success", "godev.godev20222.saved_message_title", "godev.godev20222.saved_message_content");
                        this.goBack();
                        /*{CA:ON_SAVE_START_BOTTOM:START}*/
                        /*{CA:ON_SAVE_START_BOTTOM:END}*/
                    });
            });

        /*{CA:ON_SAVE_END:START}*/
        /*{CA:ON_SAVE_END:END}*/
    }

    public onDelete() {
        /*{CA:ON_DELETE_START:START}*/
        /*{CA:ON_DELETE_START:END}*/

        this.confirmationService.confirm({
            message: this.translate.instant("godev.godev20222.delete_confirmation_message"),
            header: this.translate.instant("godev.godev20222.delete_confirmation_title"),
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(),
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            nome: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            idade: [{ value: undefined, disabled: false }, Validators.compose([Validators.required, Validators.pattern(/^\-?\d*$/)])],
            custom: [],
        });

        /*{CA:GET_FORM_CONTROLS:START}*/
        /*{CA:GET_FORM_CONTROLS:END}*/

        return formGroup;
    }

    private getFormFields() {
        const formField = [
            new FormField({
                type: FieldType.String,
                name: "id",
                required: () => false,
                label: this.translate.instant("godev.godev20222.participante_id"),
            }),
            new FormField({
                type: FieldType.String,
                name: "nome",
                required: () => true,
                label: this.translate.instant("godev.godev20222.participante_nome"),
            }),
            new FormField({
                type: FieldType.Number,
                name: "idade",
                label: this.translate.instant("godev.godev20222.participante_idade"),
                required: () => true,
                precision: 15,
                scale: 0,
            }),
        ];

        /*{CA:GET_FORM_FIELDS:START}*/
        /*{CA:GET_FORM_FIELDS:END}*/

        return formField;
    }

    private goBack() {
        const previousRoute = "../";
        this.router.navigate([previousRoute], { relativeTo: this.route.parent });
    }

    private validateAllFormFields(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(field => {
            const control = formGroup.get(field);
            if (control instanceof FormControl) control.markAsDirty({ onlySelf: true });
            else if (control instanceof FormGroup) this.validateAllFormFields(control);
        });

        this.focusService.focusFirstInvalidInput();
        /*{CA:FOCUS_FIRST_INVALID:START}*/
        /*{CA:FOCUS_FIRST_INVALID:END}*/
    }

    private getSaveObservable() {
        const { value } = this.formGroup;
        const participanteDto = Participante.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.participanteService.insert(participanteDto);
        } else {
            const id = this.routeParams.participante;
            observable = this.participanteService.update(id, participanteDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.participanteService.delete(this.routeParams.participante).pipe(
            tap(() => {
                this.addMessage("success", "godev.godev20222.deleted_message_title", "godev.godev20222.deleted_message_content");
                this.goBack();
            })
        );
    }

    private validateVisualization() {
        /*{CA:VALIDATE_VISUALIZATION_START:START}*/
        /*{CA:VALIDATE_VISUALIZATION_START:END}*/
        const toValidate: any[] = [];
        if (!toValidate.every(e => this.allPermissions[e] && this.allPermissions[e].visualizar)) {
            this.router.navigate(["forbidden"]);
        }
        /*{CA:VALIDATE_VISUALIZATION_END:START}*/
        /*{CA:VALIDATE_VISUALIZATION_END:END}*/
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/

    private addMessage(severity: string, summary: string, detail: string) {
        this.messageService.add({
            severity,
            summary: this.translate.instant(summary),
            detail: this.translate.instant(detail),
        });
    }
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
