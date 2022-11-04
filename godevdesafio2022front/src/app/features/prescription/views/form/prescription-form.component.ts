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

import { Prescription } from "~core/entities/prescription/prescription";

import { PrescriptionService } from "~core/entities/prescription/prescription.service";

import { Doctor } from "~core/entities/doctor/doctor";
import { DoctorService } from "~core/entities/doctor/doctor.service";

import { Patient } from "~core/entities/patient/patient";
import { PatientService } from "~core/entities/patient/patient.service";

import { PrecriptionType } from "~core/enums/precription-type";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./prescription-form.component.html",
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
export class PrescriptionFormComponent
    implements OnInit, OnDestroy, AfterViewInit /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public localeConfig: any = {};
    public currencyLocaleOptions: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public formFields: FormField[];
    public loading: boolean;
    public mainPanelCollapsed = false;

    public precriptionType: { label: string; value: PrecriptionType }[] = [
        { label: this.translate.instant("godev.godev2022desafio.precription_type_yellow"), value: PrecriptionType.YELLOW },
        { label: this.translate.instant("godev.godev2022desafio.precription_type_blue"), value: PrecriptionType.BLUE },
        { label: this.translate.instant("godev.godev2022desafio.precription_type_white"), value: PrecriptionType.WHITE },
    ];

    private doctorResponsibleLookupSuggestionsObservable = new Subject();
    private doctorResponsibleLookupSearchObservable = new Subject();
    private doctorResponsibleLookupDisplayFields = ["id", "name", "cpf", "crmNumber", "crmState", "especiality"];
    private doctorResponsibleAdvancedDisplayFields = ["id", "name", "cpf", "crmNumber", "crmState", "especiality"];
    private doctorResponsibleLookupSeparator = " - ";
    private doctorResponsibleSearchFields: FormField[];
    private doctorResponsibleSearchGridFields: FormField[];

    private patientLookupSuggestionsObservable = new Subject();
    private patientLookupSearchObservable = new Subject();
    private patientLookupDisplayFields = ["id", "name", "cpf", "address", "phone", "isAtivo"];
    private patientAdvancedDisplayFields = ["id", "name", "cpf", "address", "phone", "isAtivo"];
    private patientLookupSeparator = " - ";
    private patientSearchFields: FormField[];
    private patientSearchGridFields: FormField[];

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
        private prescriptionService: PrescriptionService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private fieldCustomization: FieldCustomizationService,
        private focusService: FocusService,
        private doctorService: DoctorService,
        private patientService: PatientService
    ) {
        this.doctorResponsibleSearchFields = this.getDoctorResponsibleSearchFields();
        this.doctorResponsibleSearchGridFields = this.getDoctorResponsibleSearchGridFields();

        this.patientSearchFields = this.getPatientSearchFields();
        this.patientSearchGridFields = this.getPatientSearchGridFields();

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
        return this.routeParams.prescription == "new";
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

        if (value.doctorResponsible) {
            value.doctorResponsible.label = getSuggestionValue(
                ["id", "name", "cpf", "crmNumber", "crmState", "especiality"],
                "doctorResponsible",
                value,
                this.doctorResponsibleLookupSeparator
            );
            if (value.doctorResponsible.label.trim() === this.doctorResponsibleLookupSeparator.trim()) {
                delete value.doctorResponsible.label;
            }
        }

        if (value.patient) {
            value.patient.label = getSuggestionValue(
                ["id", "name", "cpf", "address", "phone", "isAtivo"],
                "patient",
                value,
                this.patientLookupSeparator
            );
            if (value.patient.label.trim() === this.patientLookupSeparator.trim()) {
                delete value.patient.label;
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
        this.permissions = data.allPermissions.prescription;
        this.allPermissions = data.allPermissions;
        this.validateVisualization();
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            const value: any = Prescription.fromDto(data.entity);
            this.updateSuggestions(value);
            this.formGroup.patchValue(value);
        } else {
            this.formGroup.patchValue(new Prescription());
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
                        this.addMessage(
                            "success",
                            "godev.godev2022desafio.saved_message_title",
                            "godev.godev2022desafio.saved_message_content"
                        );
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
            message: this.translate.instant("godev.godev2022desafio.delete_confirmation_message"),
            header: this.translate.instant("godev.godev2022desafio.delete_confirmation_title"),
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(),
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    public onDoctorResponsibleLookupRequest(value: string) {
        /*{CA:ON_DOCTOR_RESPONSIBLE_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_DOCTOR_RESPONSIBLE_LOOKUP_REQUEST_START:END}*/
        const sort = this.doctorResponsibleLookupDisplayFields.map((field: any) => ({ field, order: 1 }));

        const filterQuery = this.doctorResponsibleSearchFields
            .filter(({ type }) => isValidFilter(type, value))
            .map(formField => createFilterString(formField, value))
            .join(" or ");

        const displayFields = mergeUnique(this.doctorResponsibleLookupDisplayFields, this.doctorResponsibleAdvancedDisplayFields);
        this.doctorService
            .list({ sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(map((list: any) => getLabelValueRequest(list.contents, this.doctorResponsibleLookupDisplayFields)))
            .subscribe((data: Doctor[]) => this.doctorResponsibleLookupSuggestionsObservable.next(data));

        /*{CA:ON_DOCTOR_RESPONSIBLE_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_DOCTOR_RESPONSIBLE_LOOKUP_REQUEST_END:END}*/
    }

    public onDoctorResponsibleSearchRequest(event: any) {
        /*{CA:ON_DOCTOR_RESPONSIBLE_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_DOCTOR_RESPONSIBLE_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const filterQuery = this.doctorResponsibleSearchFields
            .filter(({ name }) => filterData[name] != undefined && filterData[name] != "")
            .map(formField => createFilterString(formField, filterData[formField.name]))
            .join(" and ");

        const displayFields = mergeUnique(this.doctorResponsibleLookupDisplayFields, this.doctorResponsibleAdvancedDisplayFields);
        this.doctorService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(
                map((list: any) => ({
                    gridData: getLabelValueRequest(list.contents, this.doctorResponsibleLookupDisplayFields),
                    totalRecords: list.totalElements,
                }))
            )
            .subscribe((data: any) => this.doctorResponsibleLookupSearchObservable.next(data));

        /*{CA:ON_DOCTOR_RESPONSIBLE_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_DOCTOR_RESPONSIBLE_SEARCH_REQUEST_END:END}*/
    }

    public onPatientLookupRequest(value: string) {
        /*{CA:ON_PATIENT_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_PATIENT_LOOKUP_REQUEST_START:END}*/
        const sort = this.patientLookupDisplayFields.map((field: any) => ({ field, order: 1 }));

        const filterQuery = this.patientSearchFields
            .filter(({ type }) => isValidFilter(type, value))
            .map(formField => createFilterString(formField, value))
            .join(" or ");

        const displayFields = mergeUnique(this.patientLookupDisplayFields, this.patientAdvancedDisplayFields);
        this.patientService
            .list({ sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(map((list: any) => getLabelValueRequest(list.contents, this.patientLookupDisplayFields)))
            .subscribe((data: Patient[]) => this.patientLookupSuggestionsObservable.next(data));

        /*{CA:ON_PATIENT_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_PATIENT_LOOKUP_REQUEST_END:END}*/
    }

    public onPatientSearchRequest(event: any) {
        /*{CA:ON_PATIENT_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_PATIENT_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const filterQuery = this.patientSearchFields
            .filter(({ name }) => filterData[name] != undefined && filterData[name] != "")
            .map(formField => createFilterString(formField, filterData[formField.name]))
            .join(" and ");

        const displayFields = mergeUnique(this.patientLookupDisplayFields, this.patientAdvancedDisplayFields);
        this.patientService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .pipe(
                map((list: any) => ({
                    gridData: getLabelValueRequest(list.contents, this.patientLookupDisplayFields),
                    totalRecords: list.totalElements,
                }))
            )
            .subscribe((data: any) => this.patientLookupSearchObservable.next(data));

        /*{CA:ON_PATIENT_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_PATIENT_SEARCH_REQUEST_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            drug: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            data: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            doctorResponsible: [{ value: undefined, disabled: false }, Validators.compose([])],
            type: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            statementOfReponsability: [{ value: undefined, disabled: false }, Validators.compose([])],
            patient: [{ value: undefined, disabled: false }, Validators.compose([])],
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
                label: this.translate.instant("godev.godev2022desafio.prescription_id"),
            }),
            new FormField({
                type: FieldType.String,
                name: "drug",
                required: () => true,
                label: this.translate.instant("godev.godev2022desafio.prescription_drug"),
            }),
            new FormField({
                type: FieldType.String,
                name: "description",
                required: () => true,
                label: this.translate.instant("godev.godev2022desafio.prescription_description"),
            }),
            new FormField({
                type: FieldType.Date,
                name: "data",
                required: () => true,
                label: this.translate.instant("godev.godev2022desafio.prescription_data"),
                tooltip: this.translate.instant("godev.godev2022desafio.prescription_data"),
            }),
            new FormField({
                type: FieldType.Lookup,
                name: "doctorResponsible",
                dataKey: "id",
                multiple: false,
                lookupDisplayField: "label",
                required: () => false,
                label: this.translate.instant("godev.godev2022desafio.prescription_doctor_responsible"),
                searchTitle: this.translate.instant("godev.godev2022desafio.prescription_doctor_responsible_search_title"),
                searchEmptyTitle: this.translate.instant("godev.godev2022desafio.nothing_found"),
                filterLabel: this.translate.instant("godev.godev2022desafio.filter"),
                filterTitle: this.translate.instant("godev.godev2022desafio.filters"),
                clearLabel: this.translate.instant("godev.godev2022desafio.clear"),
                cancelLabel: this.translate.instant("godev.godev2022desafio.cancel"),
                selectLabel: this.translate.instant("godev.godev2022desafio.select"),
                suggestionsObservable: this.doctorResponsibleLookupSuggestionsObservable,
                searchObservable: this.doctorResponsibleLookupSearchObservable,
                onLookupRequest: (value: string) => this.onDoctorResponsibleLookupRequest(value),
                onSearchRequest: (event: any) => this.onDoctorResponsibleSearchRequest(event),
                searchFields: this.doctorResponsibleSearchFields,
                searchGridFields: this.doctorResponsibleSearchGridFields,
            }),
            new FormField({
                type: FieldType.Enum,
                name: "type",
                label: this.translate.instant("godev.godev2022desafio.prescription_type"),
                placeholder: this.translate.instant("godev.godev2022desafio.prescription_type_placeholder"),
                multiple: false,
                required: () => true,
                options: this.precriptionType,
            }),
            new FormField({
                type: FieldType.Boolean,
                name: "statementOfReponsability",
                representedBy: "switch",
                required: () => false,
                label: this.translate.instant("godev.godev2022desafio.prescription_statement_of_reponsability"),
                optionsLabel: {
                    true: this.translate.instant("godev.godev2022desafio.yes"),
                    false: this.translate.instant("godev.godev2022desafio.no"),
                    empty: this.translate.instant("godev.godev2022desafio.nothing"),
                },
            }),
            new FormField({
                type: FieldType.Lookup,
                name: "patient",
                dataKey: "id",
                multiple: false,
                lookupDisplayField: "label",
                required: () => false,
                label: this.translate.instant("godev.godev2022desafio.prescription_patient"),
                searchTitle: this.translate.instant("godev.godev2022desafio.prescription_patient_search_title"),
                searchEmptyTitle: this.translate.instant("godev.godev2022desafio.nothing_found"),
                filterLabel: this.translate.instant("godev.godev2022desafio.filter"),
                filterTitle: this.translate.instant("godev.godev2022desafio.filters"),
                clearLabel: this.translate.instant("godev.godev2022desafio.clear"),
                cancelLabel: this.translate.instant("godev.godev2022desafio.cancel"),
                selectLabel: this.translate.instant("godev.godev2022desafio.select"),
                suggestionsObservable: this.patientLookupSuggestionsObservable,
                searchObservable: this.patientLookupSearchObservable,
                onLookupRequest: (value: string) => this.onPatientLookupRequest(value),
                onSearchRequest: (event: any) => this.onPatientSearchRequest(event),
                searchFields: this.patientSearchFields,
                searchGridFields: this.patientSearchGridFields,
            }),
        ];

        /*{CA:GET_FORM_FIELDS:START}*/
        /*{CA:GET_FORM_FIELDS:END}*/

        return formField;
    }

    private getDoctorResponsibleSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev2022desafio.doctor_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "name",
                label: this.translate.instant("godev.godev2022desafio.doctor_name"),
                type: FieldType.String,
            }),
            new FormField({
                name: "cpf",
                label: this.translate.instant("godev.godev2022desafio.doctor_cpf"),
                type: FieldType.String,
            }),
            new FormField({
                name: "crmNumber",
                label: this.translate.instant("godev.godev2022desafio.doctor_crm_number"),
                type: FieldType.Integer,
            }),
            new FormField({
                name: "crmState",
                label: this.translate.instant("godev.godev2022desafio.doctor_crm_state"),
                type: FieldType.String,
            }),
            new FormField({
                name: "especiality",
                label: this.translate.instant("godev.godev2022desafio.doctor_especiality"),
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_DOCTOR_RESPONSIBLE_SEARCH_FIELDS:START}*/
        /*{CA:GET_DOCTOR_RESPONSIBLE_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getDoctorResponsibleSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev2022desafio.doctor_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "name",
                label: this.translate.instant("godev.godev2022desafio.doctor_name"),
                type: FieldType.String,
            }),
            new FormField({
                name: "cpf",
                label: this.translate.instant("godev.godev2022desafio.doctor_cpf"),
                type: FieldType.String,
            }),
            new FormField({
                name: "crmNumber",
                label: this.translate.instant("godev.godev2022desafio.doctor_crm_number"),
                type: FieldType.Integer,
            }),
            new FormField({
                name: "crmState",
                label: this.translate.instant("godev.godev2022desafio.doctor_crm_state"),
                type: FieldType.String,
            }),
            new FormField({
                name: "especiality",
                label: this.translate.instant("godev.godev2022desafio.doctor_especiality"),
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_DOCTOR_RESPONSIBLE_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_DOCTOR_RESPONSIBLE_SEARCH_GRID_FIELDS:END}*/

        return searchGridFields;
    }

    private getPatientSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev2022desafio.patient_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "name",
                label: this.translate.instant("godev.godev2022desafio.patient_name"),
                type: FieldType.String,
            }),
            new FormField({
                name: "cpf",
                label: this.translate.instant("godev.godev2022desafio.patient_cpf"),
                type: FieldType.String,
            }),
            new FormField({
                name: "address",
                label: this.translate.instant("godev.godev2022desafio.patient_address"),
                type: FieldType.String,
            }),
            new FormField({
                name: "phone",
                label: this.translate.instant("godev.godev2022desafio.patient_phone"),
                type: FieldType.Integer,
            }),
            new FormField({
                name: "isAtivo",
                label: this.translate.instant("godev.godev2022desafio.patient_is_ativo"),
                type: FieldType.Boolean,
                tooltip: "Boolean",
                optionsLabel: {
                    true: this.translate.instant("godev.godev2022desafio.true_label"),
                    false: this.translate.instant("godev.godev2022desafio.false_label"),
                    empty: this.translate.instant("godev.godev2022desafio.empty_label"),
                },
            }),
        ];

        /*{CA:GET_PATIENT_SEARCH_FIELDS:START}*/
        /*{CA:GET_PATIENT_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getPatientSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("godev.godev2022desafio.patient_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "name",
                label: this.translate.instant("godev.godev2022desafio.patient_name"),
                type: FieldType.String,
            }),
            new FormField({
                name: "cpf",
                label: this.translate.instant("godev.godev2022desafio.patient_cpf"),
                type: FieldType.String,
            }),
            new FormField({
                name: "address",
                label: this.translate.instant("godev.godev2022desafio.patient_address"),
                type: FieldType.String,
            }),
            new FormField({
                name: "phone",
                label: this.translate.instant("godev.godev2022desafio.patient_phone"),
                type: FieldType.Integer,
            }),
            new FormField({
                name: "isAtivo",
                label: this.translate.instant("godev.godev2022desafio.patient_is_ativo"),
                type: FieldType.Boolean,
                tooltip: "Boolean",
                optionsLabel: {
                    true: this.translate.instant("godev.godev2022desafio.true_label"),
                    false: this.translate.instant("godev.godev2022desafio.false_label"),
                    empty: this.translate.instant("godev.godev2022desafio.empty_label"),
                },
            }),
        ];

        /*{CA:GET_PATIENT_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_PATIENT_SEARCH_GRID_FIELDS:END}*/

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
        const prescriptionDto = Prescription.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.prescriptionService.insert(prescriptionDto);
        } else {
            const id = this.routeParams.prescription;
            observable = this.prescriptionService.update(id, prescriptionDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.prescriptionService.delete(this.routeParams.prescription).pipe(
            tap(() => {
                this.addMessage(
                    "success",
                    "godev.godev2022desafio.deleted_message_title",
                    "godev.godev2022desafio.deleted_message_content"
                );
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
