import { user as userService } from "@seniorsistemas/senior-platform-data";

export class TabviewStorageService {
    private GET_USER_ID = userService.getUserData().then(user => user.id);
    private TABVIEW_KEY = "SENIOR_TABVIEW";

    public async store(key: string, index: any) {
        sessionStorage.setItem(`${this.TABVIEW_KEY}_${await this.GET_USER_ID}_${key}`, index);
    }

    public async get(key: string) {
        return sessionStorage.getItem(`${this.TABVIEW_KEY}_${await this.GET_USER_ID}_${key}`) || 0;
    }
}
