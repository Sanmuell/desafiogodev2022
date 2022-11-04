import { user as userService } from "@seniorsistemas/senior-platform-data";

export class StorageService {
    private GET_USER_ID = userService.getUserData().then(user => user.id);

    public async store(key: string, value: any) {
        localStorage.setItem(`${await this.GET_USER_ID}_${key}`, JSON.stringify(value));
    }

    public async get(key: string) {
        return JSON.parse(localStorage.getItem(`${await this.GET_USER_ID}_${key}`)) || {};
    }
}
