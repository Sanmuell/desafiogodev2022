import { ListParams } from "../../core/entities/entity-service";
import { user as userService } from "@seniorsistemas/senior-platform-data";

export class PaginatorStorageService {
    private GET_USER_ID = userService.getUserData().then(user => user.id);
    private PAGINATOR_KEY = "SENIOR_PAGINATOR";

    public async store(key: string, value: any) {
        sessionStorage.setItem(`${await this.GET_USER_ID}_${key}`, JSON.stringify(value));
    }

    public async get(key: string) {
        return JSON.parse(sessionStorage.getItem(`${await this.GET_USER_ID}_${key}`)) || {};
    }

    public async storePaginator(key: string, listParams: ListParams = {}) {
        const store = (await this.get(this.PAGINATOR_KEY)) || {};
        store[key] = listParams;
        await this.store(this.PAGINATOR_KEY, store);
    }

    public async getPaginator(key: string) {
        const store = (await this.get(this.PAGINATOR_KEY)) || {};
        return store[key] || {};
    }
}
