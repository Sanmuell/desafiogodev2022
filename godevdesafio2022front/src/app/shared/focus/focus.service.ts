export class FocusService {
    public focusFirstInvalidInput() {
        const invalidFields = Array.from(document.getElementsByClassName("ng-invalid"));
        const firstField: any = invalidFields.find((f: any) => f.nodeName !== "FORM");
        if (firstField.nodeName === "P-CALENDAR") {
            const firstInputId = firstField.getAttribute("ng-reflect-input-id");
            const firstInvalidInput = document.getElementById(firstInputId);
            if (firstInvalidInput) firstInvalidInput.focus();
        } else if (firstField.nodeName === "S-LOOKUP") {
            const nestedInput = this.getNestedInput(firstField.firstElementChild);
            if (nestedInput) nestedInput.focus();
        } else firstField.focus();
    }

    private getNestedInput(element: any): any {
        if (element.nodeName === "INPUT") {
            return element;
        }
        return this.getNestedInput(element.firstElementChild);
    }
}
