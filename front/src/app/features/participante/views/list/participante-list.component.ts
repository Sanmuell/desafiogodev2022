import * as moment from "moment";
import { Component, OnInit, OnDestroy, TemplateRef, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { MessageService, SortMeta, LazyLoadEvent, ConfirmationService } from "primeng/api";
import { Table } from "primeng/table";
import { TranslateService } from "@ngx-translate/core";
import { Subject, forkJoin } from "rxjs";
import { takeUntil, finalize, catchError } from "rxjs/operators";
import { FormField, FieldType, IToken } from "@seniorsistemas/angular-components";
import { createFilterString, createFilterTokens } from "~shared/utils/utils";
import { FiltersStorageService } from "~shared/storage/filters-storage.service";
import { PaginatorStorageService } from "~shared/storage/paginator-storage.service";
/*{CA:EXTERNAL_IMPORTS:START}*/
/*{CA:EXTERNAL_IMPORTS:END}*/

import { Participante } from "~core/entities/participante/participante";
import { ParticipanteService } from "~core/entities/participante/participante.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./participante-list.component.html",
    styleUrls: [
        /*{CA:COMPONENT_STYLE_URLS:START}*/
        /*{CA:COMPONENT_STYLE_URLS:END}*/
    ],
    providers: [
        ConfirmationService,
        /*{CA:COMPONENT_PROVIDERS:START}
        /*{CA:COMPONENT_PROVIDERS:END}*/
    ],
    /*{CA:COMPONENT_CONFIG:START}*/
    /*{CA:COMPONENT_CONFIG:END}*/
})
export class ParticipanteListComponent implements OnInit, OnDestroy /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public allPermissions: any = {};
    public permissions: any = {};
    public localeConfig: any = {};

    public currentListParams: ListParams = { page: 0, size: 10, sort: [], filterData: {} };
    public gridData: Participante[];
    public gridColumns: any[];
    public showLoader: boolean;
    public totalRecords: number;
    public selection: Participante[];

    public filterFields: FormField[];
    public filterFormGroup: FormGroup;
    public filtersPanelCollapsed = true;
    public searchTokens: IToken[] = [];
    public serverError: boolean = false;
    public filtersLoaded = false;

    @ViewChild("participanteTable", { static: false })
    public table: Table;

    @ViewChild("customTemplate", { static: false })
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFilterFields", { static: false })
    public customFilterFields: TemplateRef<any>;

    @ViewChild("customGridColgroup", { static: false })
    public customGridColgroup: TemplateRef<any>;

    @ViewChild("customGridHeader", { static: false })
    public customGridHeader: TemplateRef<any>;

    @ViewChild("customGridBody", { static: false })
    public customGridBody: TemplateRef<any>;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    private ngUnsubscribe = new Subject();

    constructor(
        /*{CA:INJECTIONS:START}*/
        /*{CA:INJECTIONS:END}*/
        private router: Router,
        private route: ActivatedRoute,
        private participanteService: ParticipanteService,
        private confirmationService: ConfirmationService,
        private translate: TranslateService,
        private messageService: MessageService,
        private hotkeysService: HotkeysService,
        private formBuilder: FormBuilder,
        private filtersStorageService: FiltersStorageService,
        private paginatorStorageService: PaginatorStorageService
    ) {
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public ngOnInit() {
        /*{CA:ON_INIT_START:START}*/
        /*{CA:ON_INIT_START:END}*/

        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.filterFormGroup = this.formBuilder.group({
            id: [undefined, Validators.compose([])],
            nome: [undefined, Validators.compose([])],
            idade: [undefined, Validators.compose([Validators.pattern(/^\-?\d*$/)])],
        });

        this.setStoragePaginator();

        this.setStorageFiltersIntoForm(this.filterFormGroup);
        this.gridColumns = this.getGridColumns();
        this.filterFields = this.getFilterFields();

        this.setHotkeys();

        /*{CA:ON_INIT_END:START}*/
        /*{CA:ON_INIT_END:END}*/
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
                "alt+shift+e",
                () => {
                    if (this.selection && this.selection.length === 1) {
                        this.onEdit();
                    }
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+x",
                () => {
                    if (this.selection && this.selection.length && this.permissions.excluir) {
                        this.onDelete();
                    }
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+n",
                () => {
                    if (this.permissions.incluir) this.onAdd();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+f",
                () => {
                    this.onSearch();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+l",
                () => {
                    this.onClear();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        /*{CA:SET_HOTKEYS_END:START}*/
        /*{CA:SET_HOTKEYS_END:END}*/
    }

    public onRouteDataChange(data: any) {
        /*{CA:ON_ROUTE_DATA_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_START:END}*/

        this.allPermissions = data.allPermissions;
        this.permissions = data.allPermissions.participante;
        this.localeConfig = data.localeConfig;

        /*{CA:ON_ROUTE_DATA_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_END:END}*/
    }

    // Verifica se o objeto possui um valor que foi alterado para "" (String vazia) ao inves de null ou undefined
    private hasEmpty(target: any) {
        if (Object.keys(target).filter(key => target[key] === "").length > 0) return true;
    }

    public onSearch() {
        /*{CA:ON_SEARCH_START:START}*/
        /*{CA:ON_SEARCH_START:END}*/

        const filterData = this.filterFormGroup.getRawValue();

        if (this.hasEmpty(filterData)) {
            this.filtersPanelCollapsed = true;
            return this.validateAllFormFields(this.filterFormGroup);
        } else {
            this.filtersPanelCollapsed = true;
            this.resetGrid({ filterData });
            this.filtersStorageService.storeFilters("ParticipanteListComponent", filterData);
        }

        /*{CA:ON_SEARCH_END:START}*/
        /*{CA:ON_SEARCH_END:END}*/
    }

    public onClear() {
        /*{CA:ON_CLEAR_START:START}*/
        /*{CA:ON_CLEAR_START:END}*/

        this.filterFormGroup.reset();
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });
        this.filtersStorageService.removeFilter("ParticipanteListComponent");

        /*{CA:ON_CLEAR_END:START}*/
        /*{CA:ON_CLEAR_END:END}*/
    }

    public onRemoveToken(token: IToken) {
        /*{CA:ON_REMOVE_TOKEN_START:START}*/
        /*{CA:ON_REMOVE_TOKEN_START:END}*/

        this.filterFormGroup.get(token.id).setValue(undefined);
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });
        this.filtersStorageService.clearFilterValue("ParticipanteListComponent", filterData);

        /*{CA:ON_REMOVE_TOKEN_END:START}*/
        /*{CA:ON_REMOVE_TOKEN_END:END}*/
    }

    public onGridChange(event: LazyLoadEvent) {
        /*{CA:ON_GRID_CHANGE_START:START}*/
        /*{CA:ON_GRID_CHANGE_START:END}*/

        const size = event.rows;
        const page = event.first / size;
        const sort = event.multiSortMeta;

        if (size != 10 || page != 0 || sort.length > 0) {
            this.paginatorStorageService.storePaginator("ParticipanteListComponentPaginator", { page, size, sort });
        }

        return this.updateGrid({ page, size, sort });

        /*{CA:ON_GRID_CHANGE_END:START}*/
        /*{CA:ON_GRID_CHANGE_END:END}*/
    }

    public onAdd() {
        /*{CA:ON_ADD_START:START}*/
        /*{CA:ON_ADD_START:END}*/

        this.router.navigate(["new"], { relativeTo: this.route });

        /*{CA:ON_ADD_END:START}*/
        /*{CA:ON_ADD_END:END}*/
    }

    public onEdit() {
        /*{CA:ON_EDIT_START:START}*/
        /*{CA:ON_EDIT_START:END}*/

        this.router.navigate([this.selection[0].id], { relativeTo: this.route });

        /*{CA:ON_EDIT_END:START}*/
        /*{CA:ON_EDIT_END:END}*/
    }

    public onDelete() {
        /*{CA:ON_DELETE_START:START}*/
        /*{CA:ON_DELETE_START:END}*/

        this.confirmationService.confirm({
            message: this.translate.instant("godev.godev20222.delete_confirmation_message"),
            header: this.translate.instant("godev.godev20222.delete_confirmation_title"),
            accept: () => {
                forkJoin(this.selection.map(participante => this.participanteService.delete(participante.id)))
                    .pipe(
                        takeUntil(this.ngUnsubscribe),
                        finalize(() => {
                            /*{CA:ON_DELETE_FINALIZE_TOP:START}*/
                            /*{CA:ON_DELETE_FINALIZE_TOP:END}*/
                            this.resetGrid();
                            /*{CA:ON_DELETE_FINALIZE_BOTTOM:START}*/
                            /*{CA:ON_DELETE_FINALIZE_BOTTOM:END}*/
                        })
                    )
                    .subscribe(
                        () => {
                            /*{CA:ON_DELETE_START_TOP:START}*/
                            /*{CA:ON_DELETE_START_TOP:END}*/
                            this.messageService.add({
                                severity: "success",
                                summary: this.translate.instant("godev.godev20222.deleted_message_title"),
                                detail: this.translate.instant("godev.godev20222.deleted_message_content"),
                            });
                            /*{CA:ON_DELETE_START_BOTTOM:START}*/
                            /*{CA:ON_DELETE_START_BOTTOM:END}*/
                        },
                        error => {
                            /*{CA:ON_DELETE_ERROR_TOP:START}*/
                            /*{CA:ON_DELETE_ERROR_TOP:END}*/
                        }
                    );
            },
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    public focusInput(elementId: string) {
        const element = document.getElementById(`${elementId}`);
        if (element) {
            element.focus();
        }
    }

    public getProp(obj: any, path: any) {
        return path.split(".").reduce((result: any, prop: any) => (result[prop] === undefined ? "" : result[prop]), obj);
    }

    private getGridColumns() {
        const gridColumns = [
            { field: "id", header: this.translate.instant("godev.godev20222.participante_id") },
            { field: "nome", header: this.translate.instant("godev.godev20222.participante_nome") },
            { field: "idade", header: this.translate.instant("godev.godev20222.participante_idade") },
        ];

        /*{CA:GET_GRID_COLUMNS:START}*/
        /*{CA:GET_GRID_COLUMNS:END}*/

        return gridColumns;
    }

    private getFilterFields() {
        const filterFields = [
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

        /*{CA:GET_SEARCH_FIELDS:START}*/
        /*{CA:GET_SEARCH_FIELDS:END}*/

        return filterFields;
    }

    private async setStorageFiltersIntoForm(form: FormGroup) {
        this.showLoader = true;
        const filters = await this.filtersStorageService.getFilters("ParticipanteListComponent");

        Object.keys(form.controls).forEach(field => {
            const isDate = moment(filters[field], moment.HTML5_FMT.DATETIME_LOCAL_MS + "Z", true).isValid();
            form.get(field).setValue(isDate ? new Date(filters[field]) : filters[field]);
        });

        this.filtersLoaded = true;
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });

        /*{CA:GET_FILTER_FORM_GROUP:START}*/
        /*{CA:GET_FILTER_FORM_GROUP:END}*/
    }

    private async setStoragePaginator() {
        const paginator = await this.paginatorStorageService.getPaginator("ParticipanteListComponentPaginator");

        if (JSON.stringify(paginator) != "{}") {
            this.currentListParams = { ...this.currentListParams, ...paginator };
        }

        /*{CA:GET_FILTER_FORM_GROUP:START}*/
        /*{CA:GET_FILTER_FORM_GROUP:END}*/
    }

    private updateGrid(listParams: ListParams = {}) {
        if (!this.filtersLoaded) return;

        this.showLoader = true;
        this.currentListParams = { ...this.currentListParams, ...listParams };
        const { page, size, filterData } = this.currentListParams;
        let { sort } = this.currentListParams;

        this.searchTokens = this.filterFields
            .filter(({ name }) => filterData[name] != undefined && filterData[name] !== "")
            .map(formField => createFilterTokens(formField, filterData[formField.name], this.translate));

        const filterQuery = this.filterFields
            .filter(({ name }) => filterData[name] != undefined)
            .map(formField => createFilterString(formField, filterData[formField.name]))
            .join(" and ");

        const displayFields = this.gridColumns.map(column => column.field);

        this.participanteService
            .list({ page, size, sort, filterQuery, displayFields })
            .pipe(
                takeUntil(this.ngUnsubscribe),
                catchError((err: any) => {
                    if (err.status >= 500 && err.status < 600) this.serverError = true;
                    throw err;
                }),
                finalize(() => {
                    this.showLoader = false;
                })
            )
            .subscribe((list: any) => {
                this.selection = [];
                this.gridData = list.contents;
                this.totalRecords = list.totalElements;
                this.serverError = false;
            });
    }

    public resetGrid(listParams?: ListParams) {
        if (listParams) this.currentListParams = { ...this.currentListParams, ...listParams };

        this.updateGrid(this.currentListParams);
    }

    private validateAllFormFields(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(field => {
            const control = formGroup.get(field);
            if (control instanceof FormControl) control.markAsDirty({ onlySelf: true });
            else if (control instanceof FormGroup) this.validateAllFormFields(control);
        });
    }

    public getPageSize() {
        return this.currentListParams.size;
    }

    public getRowIndex() {
        return this.currentListParams.page * this.currentListParams.size;
    }

    public getSortField() {
        if (this.currentListParams.sort.length <= 0) return this.gridColumns[0].field;

        return this.currentListParams.sort[0].field;
    }

    public getSortOrder() {
        if (this.currentListParams.sort.length <= 0) return 1;

        return this.currentListParams.sort[0].order;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

interface ListParams {
    page?: number;
    size?: number;
    sort?: SortMeta[];
    filterData?: any;
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
