import * as moment from "moment";
import { FieldType, FormField, Option } from "@seniorsistemas/angular-components";
import { TranslateService } from "@ngx-translate/core";

const numberTypes = [FieldType.Integer, FieldType.Double];
const numberPattern = /^\d+\b$/;

export const mergeUnique = (array: Array<string>, otherArray: Array<string>) =>
    array.concat(otherArray.filter(item => !array.includes(item)));

export const getTypeInformation = (type: FieldType, value: any) => {
    switch (type) {
        case FieldType.Time:
        case FieldType.Date:
        case FieldType.LocalDateTime:
        case FieldType.DateTime:
            return { isValidValue: false, typeExists: true };
        case FieldType.Integer:
        case FieldType.Double:
            return {
                isValidValue: value.match(numberPattern),
                typeExists: numberTypes.includes(type),
            };
        default:
            return {
                isValidValue: value.match(numberPattern),
                typeExists: numberTypes.includes(type),
            };
    }
};

export const isValidFilter = (type: FieldType, value: any) => {
    const { isValidValue, typeExists } = getTypeInformation(type, value);
    return !(typeExists && !isValidValue);
};

export const getProp = (obj: any, path: any) => {
    return path.split(".").reduce((result: any, prop: any) => (result[prop] === undefined ? "" : result[prop]), obj);
};

export const getLabelValueRequest = (contents: any[], displayFields: any[]) => {
    return contents.map((item: any) => ({
        ...item,
        label: displayFields.map(field => getProp(item, field)).join(" - "),
    }));
};

export const getSuggestionValue = (displayFields: string[], ownerEntity: string, value: any, separator: string) => {
    return (
        displayFields.map(field => getProp(value, `${ownerEntity}.${field}`)).reduce((acc: any, val: any) => `${acc}${separator}${val}`) +
        ""
    );
};

export const getEnumQuery = (name: string, value: any, multiple: boolean = false) => {
    if (multiple) {
        return `(${value.map((selected: any) => `${name} eq '${selected}'`).join(" or ")})`;
    }
    return `${name} eq '${value}'`;
};

export const createFilterString = (formField: FormField, value: any) => {
    const { name, type, multiple } = formField;
    if (typeof value == "number") {
        return `${name} eq ${value}`;
    }

    switch (type) {
        case FieldType.Date:
            return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
        case FieldType.Time:
            return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
        case FieldType.DateTime:
            return `${name} eq '${moment(value).format()}'`;
        case FieldType.LocalDateTime:
            return `${name} eq '${moment(value).format("YYYY-MM-DD[T]HH:mm:ss.SSS")}'`;
        case FieldType.Enum:
            return getEnumQuery(name, value, multiple);
        case FieldType.String:
            return `containing(upper(${name}), upper('${value.replace(/'/g, "'")}'))`;
        case FieldType.Lookup:
            return `${name} eq '${value.id}'`;
        default:
            return `${name} eq '${value}'`;
    }
};

export const createFilterTokens = (formField: FormField, value: any, translate: TranslateService) => {
    const { name, type, label, searchFields, options } = formField as any;
    let labelValue = value;

    switch (type) {
        case FieldType.Date:
            labelValue = moment(value).format("L");
            break;
        case FieldType.Time:
            labelValue = moment(value).format("LTS");
            break;
        case FieldType.LocalDateTime:
        case FieldType.DateTime:
            labelValue = moment(value).format("L LTS");
            break;
        case FieldType.Lookup:
            labelValue = searchFields.map((field: FormField) => getProp(value, field.name)).join(" - ");
            break;
        case FieldType.Enum:
            labelValue = options.filter((option: Option) => option.value === labelValue)[0].label;
            break;
        case FieldType.Boolean:
            labelValue = value
                ? translate.instant("platform.localization.list_grid_boolean_true")
                : translate.instant("platform.localization.list_grid_boolean_false");
            break;
    }

    return { id: name, label: `${label}: ${labelValue}` };
};
