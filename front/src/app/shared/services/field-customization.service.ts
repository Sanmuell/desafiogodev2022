import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/api";
import { throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { FormGroup } from "@angular/forms";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class FieldCustomizationService {
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    constructor(protected http: HttpClient, protected messageService: MessageService) {
        this.http = http;
        this.messageService = messageService;
        this.defaultCatch = this.defaultCatch.bind(this);
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public commitFiles(objects: any[]) {
        return this.http.post("platform/field_customization/actions/commitObject", { objects }).pipe(this.defaultCatch());
    }

    public deleteFiles(objects: any) {
        return this.http.post("platform/field_customization/actions/deleteObjects", objects).pipe(this.defaultCatch());
    }

    public getFiles(formGroup: FormGroup) {
        let fieldCustomization = [];

        if (formGroup.value.custom) {
            fieldCustomization = formGroup.value.custom.fieldCustomization || [];
            delete formGroup.value.custom.fieldCustomization;
        }

        const filesToCommit: any[] = [];
        let filesToDelete: any = {};

        fieldCustomization.forEach(({ domain, service, entity, toDelete, toInsert }: any) => {
            if (!this.isEmpty(toInsert)) {
                const files = Object.keys(toInsert).map((key: string) => {
                    const version = toInsert[key].version;
                    const fileName = toInsert[key].name;
                    const objectId = toInsert[key].objectId;
                    return { version, fileName, objectId };
                });

                if (!this.isEmpty(files)) {
                    filesToCommit.push(...files);
                }
            }

            if (!this.isEmpty(toDelete)) {
                const objects: any[] = [];
                Object.keys(toDelete).forEach((key: string) => {
                    const fields = toDelete[key] || [];
                    const files = fields.map((file: string) => {
                        return {
                            field: key,
                            objectId: file,
                        };
                    });
                    objects.push(...files);
                });
                filesToDelete = { domain, service, entityName: entity, objects };
            }
        });

        return { filesToCommit, filesToDelete };
    }

    public isEmpty(object: any) {
        if (Array.isArray(object)) {
            return object.length === 0;
        }
        return Object.entries(object).length === 0 && object.constructor === Object;
    }

    public defaultCatch() {
        return catchError((err: any) => {
            if (err) {
                const summary = err.status ? String(err.status) : "Error";
                const detail = (err.error && err.error.message) || err.statusText || err.message || "Error";

                this.messageService.add({
                    severity: "error",
                    summary,
                    detail,
                });
            }

            return throwError(err);
        });
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
