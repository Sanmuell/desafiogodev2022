import { HttpParams, HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/api";
import { TranslateService } from "@ngx-translate/core";
import { SortMeta } from "primeng/api";
import { throwError } from "rxjs";
import { catchError } from "rxjs/operators";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class EntityService<T> {
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    constructor(
        protected http: HttpClient,
        protected messageService: MessageService,
        protected entityUrl: string,
        protected actionsUrl: string,
        protected translate: TranslateService
    ) {
        this.http = http;
        this.messageService = messageService;
        this.entityUrl = entityUrl;
        this.actionsUrl = actionsUrl;
        this.translate = translate;

        this.defaultCatch = this.defaultCatch.bind(this);

        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public getListQueryParams(listParams: ListParams) {
        const { page = 0, size = 10, sort = [], filterQuery = "", displayFields = [] } = listParams;

        let params = new HttpParams();
        params = params.append("size", String(size));
        params = params.append("offset", String(page));

        if (sort && sort.length) {
            params = params.append(
                "orderby",
                sort
                    .map(s => {
                        let order = "";
                        if (s.order === 1) order = " asc";
                        else if (s.order === -1) order = " desc";
                        return `${s.field}${order}`;
                    })
                    .join(", ")
            );
        }

        if (filterQuery) params = params.append("filter", filterQuery);

        if (displayFields && displayFields.length) params = params.append("displayfields", displayFields.join());

        return params;
    }

    private getBodyParams(listParams: ListParams): BodyParams {
        const { page = 0, size = 10, sort = [], filterQuery = "", displayFields = [] } = listParams;
        const bodyParams: BodyParams = {};

        bodyParams.size = size;
        bodyParams.offset = page;

        if (sort && sort.length) {
            bodyParams.orderBy = sort
                .map(s => {
                    let order = "";
                    if (s.order === 1) order = " asc";
                    else if (s.order === -1) order = " desc";
                    return `${s.field}${order}`;
                })
                .join(", ");
        }

        if (filterQuery) bodyParams.filter = filterQuery;

        if (displayFields && displayFields.length) bodyParams.displayfields = displayFields.join();

        return bodyParams;
    }

    public defaultCatch() {
        return catchError((err: any) => {
            if (err) {
                let summary = err.status ? String(err.status) : "Error";
                let detail = (err.error && err.error.message) || err.statusText || err.message || "Error";

                if (err.status === 401) {
                    summary = this.translate.instant("godev.godev20222.error_unauthorized_title");
                    detail = this.translate.instant("godev.godev20222.error_unauthorized_description");
                }

                this.messageService.add({
                    severity: "error",
                    summary,
                    detail,
                });
            }

            return throwError(err);
        });
    }

    public list(listParams: ListParams) {
        return this.http.get<T[]>(this.entityUrl, { params: this.getListQueryParams(listParams) }).pipe(this.defaultCatch());
    }

    public get(id: any) {
        return this.http.get<T>(`${this.entityUrl}/${id}`).pipe(this.defaultCatch());
    }

    public insert(entity: T) {
        return this.http.post<T>(`${this.entityUrl}`, entity).pipe(this.defaultCatch());
    }

    public update(id: any, entity: T) {
        return this.http.put<T>(`${this.entityUrl}/${id}`, entity).pipe(this.defaultCatch());
    }

    public delete(id: any) {
        return this.http.delete<T>(`${this.entityUrl}/${id}`).pipe(this.defaultCatch());
    }

    public listCustomFilter(listParams: ListParams, action: string) {
        return this.http.post<T[]>(`${this.actionsUrl}/${action}`, this.getBodyParams(listParams)).pipe(this.defaultCatch());
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

export interface ListParams {
    page?: number;
    size?: number;
    sort?: SortMeta[];
    filterQuery?: string;
    displayFields?: string[];
}

export interface BodyParams {
    offset?: number;
    size?: number;
    orderBy?: string;
    filter?: string;
    displayfields?: string;
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
