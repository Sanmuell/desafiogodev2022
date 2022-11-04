import { MainPage } from "~e2e/src/main.po";

describe("Project godev-2022-frontend", () => {
    let mainPage: MainPage;

    beforeEach(() => {
        mainPage = new MainPage();
    });

    it("should display project name", () => {
        mainPage.navigateTo();
        expect(mainPage.getTitleText()).toEqual("godev-2022-frontend".toUpperCase());
    });
});
