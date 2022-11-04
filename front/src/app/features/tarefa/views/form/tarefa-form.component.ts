import { Component, OnInit, OnDestroy, TemplateRef, ViewChild, AfterViewInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { MessageService, ConfirmationService } from "primeng/api";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { TranslateService } from "@ngx-translate/core";
import { Subject, throwError, forkJoin, of } from "rxjs";
import { FocusService } from "~shared/focus/focus.service";
import { FieldCustomizationService } from "~shared/services/field-customization.service";
import { mergeUnique, isValidFilter, getSuggestionValue, getLabelValueRequest, createFilterString } from "~shared/utils/utils";
import { map, tap, takeUntil, catchError } from "rxjs/operators";
import { FormField, FieldType } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { Tarefa } from "~core/entities/tarefa/tarefa";

import { TarefaService } from "~core/entities/tarefa/tarefa.service";

import { Participante } from "~core/entities/participante/participante";
import { ParticipanteService } from "~core/entities/participante/participante.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./tarefa-form.component.html",
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
export class TarefaFormComponent implements OnInit, OnDestroy, AfterViewInit /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public localeConfig: any = {};
    public currencyLocaleOptions: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public formFields: FormField[];
    public loading: boolean;
    public mainPanelCollapsed = false;

    private participantesLookupSuggestionsObservable = new Subject();
    private participantesLookupSearchObservable = new Subject();
    private participantesLookupDisplayFields = ["id", "nome", "idade"];
    private participantesAdvancedDisplayFields = ["id", "nome", "idade"];
    private participantesLookupSeparator = " - ";
    private participantesSearchFields: FormField[];
    private participantesSearchGridFields: FormField[];

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
        private tarefaService: TarefaService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private fieldCustomization: FieldCustomizationService,
        private focusService: FocusService,
        private participanteService: ParticipanteService
    ) {
        this.participantesSearchFields = this.getParticipantesSearchFields();
        this.participantesSearchGridFields = this.getParticipantesSearchGridFields();

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
        return this.routeParams.tarefa == "new";
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

        if (value.participantes) {
            value.participantes.label = getSuggestionValue(
                ["id", "nome", "idade"],
                "participantes",
                value,
                this.participantesLookupSeparator
            );
            if (value.participantes.label.trim() === this.participantesLookupSeparator.trim()) {
                delete value.participantes.label;
            }
        }

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
        this.permissions = data.allPermissions.tarefa;
        this.allPermissions = data.allPermissions;
        this.validateVisualization();
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            const value: any = Tarefa.fromDto(data.entity);
            this.updateSuggestions(value);
            this.formGroup.patchValue(value);
        } else {
            this.formGroup.patchValue(new Tarefa());
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

    public onParticipantesLookupRequest(value: string) {
        /*{CA:ON_PARTICIPANTES_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_PARTICIPANTES_LOOKUP_REQUEST_START:END}*/
        const sort = this.participantesLookupDisplayFields.map((field: any) => ({ field, order: 1 }));

        const filterQuery = this.participantesSearchFields
            .filter(({ type }) => isValidFilter(type, value))
            .map(formField => createFilterString(formField, value))
            .join(" or ");

        const displayFields = mergeUnique(this.participantesLookupDisplayFields, this.participantesAdvancedDisplayFields);
        this.participanteService
            .list({ sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(map((list: any) => getLabelValueRequest(list.contents, this.participantesLookupDisplayFields)))
            .subscribe((data: Participante[]) => this.participantesLookupSuggestionsObservable.next(data));

        /*{CA:ON_PARTICIPANTES_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_PARTICIPANTES_LOOKUP_REQUEST_END:END}*/
    }

    public onParticipantesSearchRequest(event: any) {
        /*{CA:ON_PARTICIPANTES_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_PARTICIPANTES_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const filterQuery = this.participantesSearchFields
            .filter(({ name }) => filterData[name] != undefined && filterData[name] != "")
            .map(formField => createFilterString(formField, filterData[formField.name]))
            .join(" and ");

        const displayFields = mergeUnique(this.participantesLookupDisplayFields, this.participantesAdvancedDisplayFields);
        this.participanteService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(
                map((list: any) => ({
                    gridData: getLabelValueRequest(list.contents, this.participantesLookupDisplayFields),
                    totalRecords: list.totalElements,
                }))
            )
            .subscribe((data: any) => this.participantesLookupSearchObservable.next(data));

        /*{CA:ON_PARTICIPANTES_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_PARTICIPANTES_SEARCH_REQUEST_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            descricao: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            participantes: [{ value: undefined, disabled: false }, Validators.compose([])],
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
                label: this.translate.instant("godev.godev20222.tarefa_id"),
            }),
            new FormField({
                type: FieldType.String,
                name: "descricao",
                required: () => true,
                label: this.translate.instant("godev.godev20222.tarefa_descricao"),
            }),
            new FormField({
                type: FieldType.Lookup,
                name: "participantes",
                dataKey: "id",
                multiple: true,
                lookupDisplayField: "label",
                required: () => false,
                label: this.translate.instant("godev.godev20222.tarefa_participantes"),
                searchTitle: this.translate.instant("godev.godev20222.tarefa_participantes_search_title"),
                searchEmptyTitle: this.translate.instant("godev.godev20222.nothing_found"),
                filterLabel: this.translate.instant("godev.godev20222.filter"),
                filterTitle: this.translate.instant("godev.godev20222.filters"),
                clearLabel: this.translate.instant("godev.godev20222.clear"),
                cancelLabel: this.translate.instant("godev.godev20222.cancel"),
                selectLabel: this.translate.instant("godev.godev20222.select"),
                suggestionsObservable: this.participantesLookupSuggestionsObservable,
                searchObservable: this.participantesLookupSearchObservable,
                onLookupRequest: (value: string) => this.onParticipantesLookupRequest(value),
                onSearchRequest: (event: any) => this.onParticipantesSearchRequest(event),
                searchFields: this.participantesSearchFields,
                searchGridFields: this.participantesSearchGridFields,
            }),
        ];

        /*{CA:GET_FORM_FIELDS:START}*/
        /*{CA:GET_FORM_FIELDS:END}*/

        return formField;
    }

    private getParticipantesSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev20222.participante_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "nome",
                label: this.translate.instant("godev.godev20222.participante_nome"),
                type: FieldType.String,
            }),
            new FormField({
                name: "idade",
                label: this.translate.instant("godev.godev20222.participante_idade"),
                type: FieldType.Integer,
            }),
        ];

        /*{CA:GET_PARTICIPANTES_SEARCH_FIELDS:START}*/
        /*{CA:GET_PARTICIPANTES_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getParticipantesSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev20222.participante_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "nome",
                label: this.translate.instant("godev.godev20222.participante_nome"),
                type: FieldType.String,
            }),
            new FormField({
                name: "idade",
                label: this.translate.instant("godev.godev20222.participante_idade"),
                type: FieldType.Integer,
            }),
        ];

        /*{CA:GET_PARTICIPANTES_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_PARTICIPANTES_SEARCH_GRID_FIELDS:END}*/

        return searchGridFields;
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
        const tarefaDto = Tarefa.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.tarefaService.insert(tarefaDto);
        } else {
            const id = this.routeParams.tarefa;
            observable = this.tarefaService.update(id, tarefaDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.tarefaService.delete(this.routeParams.tarefa).pipe(
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
