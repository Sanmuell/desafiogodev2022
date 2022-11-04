import { Component, OnInit, OnDestroy } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Subject } from "rxjs";
import { takeUntil } from "rxjs/operators";

@Component({
    templateUrl: "./error-page.component.html",
})
export class ErrorPageComponent implements OnInit, OnDestroy {
    public errorTitle: string;
    public errorDescription: string;
    public errorCode: number;

    private ngUnsubscribe = new Subject();

    constructor(private route: ActivatedRoute) {}

    public ngOnInit() {
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public onRouteDataChange(data: any) {
        this.errorTitle = data.translations.title;
        this.errorDescription = data.translations.description;
        this.errorCode = data.errorCode;
    }
}
