import { FieldType, FormField } from "@seniorsistemas/angular-components";
import { createFilterString, createFilterTokens, getEnumQuery, getLabelValueRequest, getProp, getSuggestionValue } from "./utils";

describe("Shared - Utils", () => {
    describe("getProp", () => {
        it("should return the property value", () => {
            const obj = {
                prop: "Prop1",
                otherProps: "OtherProps",
            };

            const result = getProp(obj, "prop");
            expect(result).toBe("Prop1");
        });

        it("should return the property value if the path has inner props", () => {
            const obj = {
                prop: {
                    innerProp: "InnerProp",
                },
                otherProps: "OtherProps",
            };

            const result = getProp(obj, "prop.innerProp");
            expect(result).toBe("InnerProp");
        });

        it("should return an empty string if the value is undefined", () => {
            const obj = {
                prop: {},
                otherProps: "OtherProps",
            };

            const result = getProp(obj, "prop.innerProp");
            expect(result).toBe("");
        });
    });

    describe("getLabelValueRequest", () => {
        it("should return the content with the label prop", () => {
            const content = [
                {
                    id: "id",
                    description: "description",
                },
            ];
            const result = getLabelValueRequest(content, ["id", "description"]);
            expect(result[0]).toEqual({
                id: "id",
                description: "description",
                label: "id - description",
            });
        });

        it("should create the label with inner props", () => {
            const content = [
                {
                    id: "id",
                    description: "description",
                    assoc: {
                        description: "assoc description",
                    },
                },
            ];

            const result = getLabelValueRequest(content, ["assoc.description"]);
            expect(result[0]).toEqual({
                id: "id",
                description: "description",
                assoc: {
                    description: "assoc description",
                },
                label: "assoc description",
            });
        });
    });

    describe("getSuggestionValue", () => {
        it("should return the suggestion value", () => {
            const obj = {
                id: "id",
                description: "description",
                city: {
                    id: "city id",
                    name: "city name",
                },
            };
            const result = getSuggestionValue(["id", "name"], "city", obj, " * ");
            expect(result).toBe("city id * city name");
        });
    });

    describe("getEnumQuery", () => {
        it("should return the filter query for a single value with default multiple value", () => {
            const result = getEnumQuery("tipPes", "PJ");
            expect(result).toBe("tipPes eq 'PJ'");
        });

        it("should return the filter query for a single value", () => {
            const result = getEnumQuery("tipPes", "PJ", false);
            expect(result).toBe("tipPes eq 'PJ'");
        });

        it("should return the filter query for a multiple value", () => {
            const result = getEnumQuery("tipPes", ["PJ", "PF", "NA"], true);
            expect(result).toBe("(tipPes eq 'PJ' or tipPes eq 'PF' or tipPes eq 'NA')");
        });
    });

    describe("createFilterString", () => {
        it("should return the filter for a number value", () => {
            const formField = new FormField({ type: FieldType.Number, name: "fieldName" });
            const result = createFilterString(formField, 15.2);
            expect(result).toBe("fieldName eq 15.2");
        });

        it("should return the filter for a date value", () => {
            const filterValue = new Date(2022, 5, 10);
            const formField = new FormField({ type: FieldType.Date, name: "fieldName" });
            const result = createFilterString(formField, filterValue);
            expect(result).toBe("fieldName eq '2022-06-10'");
        });

        it("should return the filter for a time value", () => {
            const filterValue = new Date(2022, 5, 10, 23, 41, 55);
            const formField = new FormField({ type: FieldType.Time, name: "fieldName" });
            const result = createFilterString(formField, filterValue);
            expect(result).toBe("fieldName eq '23:41:55'");
        });

        it("should return the filter for a dateTime value", () => {
            const filterValue = new Date(2022, 5, 10, 23, 41, 55);
            const formField = new FormField({ type: FieldType.DateTime, name: "fieldName" });
            const result = createFilterString(formField, filterValue);
            expect(result).toBe("fieldName eq '2022-06-10T23:41:55-03:00'");
        });

        it("should return the filter for a single value enum", () => {
            const filterValue = "PF";
            const formField = new FormField({ type: FieldType.Enum, name: "fieldName" });
            const result = createFilterString(formField, filterValue);
            expect(result).toBe("fieldName eq 'PF'");
        });

        it("should return the filter for a multiple value enum", () => {
            const filterValue = ["PF", "PJ"];
            const formField = new FormField({ type: FieldType.Enum, name: "fieldName", multiple: true });
            const result = createFilterString(formField, filterValue);
            expect(result).toBe("(fieldName eq 'PF' or fieldName eq 'PJ')");
        });

        it("should return the filter for a string value", () => {
            const formField = new FormField({ type: FieldType.String, name: "fieldName" });
            const result = createFilterString(formField, "some text");
            expect(result).toBe("containing(upper(fieldName), upper('some text'))");
        });

        it("should return the filter for a lookup value", () => {
            const filterValue = {
                id: "filter id",
                name: "name",
            };
            const formField = { type: FieldType.Lookup, name: "fieldName" };
            const result = createFilterString(formField as any, filterValue);
            expect(result).toBe("fieldName eq 'filter id'");
        });

        it("should return the filter the other field types", () => {
            let result = createFilterString({ type: FieldType.Binary, name: "fieldName" } as any, "some value");
            expect(result).toBe("fieldName eq 'some value'");

            result = createFilterString({ type: FieldType.Autocomplete, name: "fieldName" } as any, "some value");
            expect(result).toBe("fieldName eq 'some value'");

            result = createFilterString({ type: FieldType.Blob, name: "fieldName" } as any, "some value");
            expect(result).toBe("fieldName eq 'some value'");

            result = createFilterString({ type: FieldType.Boolean, name: "fieldName" } as any, true);
            expect(result).toBe("fieldName eq 'true'");

            result = createFilterString({ type: FieldType.Custom, name: "fieldName" } as any, "some value");
            expect(result).toBe("fieldName eq 'some value'");
        });
    });

    describe("createFilterTokens", () => {
        it("should return the token for a date value", () => {
            const filterValue = new Date(2022, 5, 10);
            const formField = new FormField({ type: FieldType.Date, name: "fieldName", label: "Field" });
            const result = createFilterTokens(formField, filterValue, null);
            expect(result).toEqual({ id: "fieldName", label: "Field: 06/10/2022" });
        });

        it("should return the token for a time value", () => {
            const filterValue = new Date(2022, 5, 10, 23, 41, 55);
            const formField = new FormField({ type: FieldType.Time, name: "fieldName", label: "Field" });
            const result = createFilterTokens(formField, filterValue, null);
            expect(result).toEqual({ id: "fieldName", label: "Field: 11:41:55 PM" });
        });

        it("should return the token for a dateTime value", () => {
            const filterValue = new Date(2022, 5, 10, 23, 41, 55);
            const formField = new FormField({ type: FieldType.DateTime, name: "fieldName", label: "Field" });
            const result = createFilterTokens(formField, filterValue, null);
            expect(result).toEqual({ id: "fieldName", label: "Field: 06/10/2022 11:41:55 PM" });
        });

        it("should return the token for a lookup field", () => {
            const filterValue = {
                id: "id",
                name: "name",
            };
            const formField = {
                type: FieldType.Lookup,
                name: "fieldName",
                label: "Field",
                searchFields: [
                    new FormField({ type: FieldType.String, name: "id" }),
                    new FormField({ type: FieldType.String, name: "name" }),
                ],
            };
            const result = createFilterTokens(formField, filterValue, null);
            expect(result).toEqual({ id: "fieldName", label: "Field: id - name" });
        });

        it("should return the token for a enum field", () => {
            const filterValue = "VA";
            const formField = {
                type: FieldType.Enum,
                name: "fieldName",
                label: "Field",
                options: [
                    {
                        value: "VA",
                        label: "VA - Label",
                    },
                    {
                        value: "VI",
                        label: "VI - Label",
                    },
                ],
            };
            const result = createFilterTokens(formField, filterValue, null);
            expect(result).toEqual({ id: "fieldName", label: "Field: VA - Label" });
        });

        it("should return the token for a boolean field", () => {
            const formField = {
                type: FieldType.Boolean,
                name: "fieldName",
                label: "Field",
            };
            const mockTranslate = {
                instant: (key: string) => key,
            };

            let result = createFilterTokens(formField, true, mockTranslate as any);
            expect(result.label.includes("list_grid_boolean_true")).toBe(true);

            result = createFilterTokens(formField, false, mockTranslate as any);
            expect(result.label.includes("list_grid_boolean_false")).toBe(true);
        });
    });
});
