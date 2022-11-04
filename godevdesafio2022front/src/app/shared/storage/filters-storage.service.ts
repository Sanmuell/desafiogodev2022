import { StorageService } from "./storage.service";

export class FiltersStorageService extends StorageService {
    private FILTERS_KEY = "SENIOR_FILTERS";

    public async storeFilters(key: string, filters: any) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        this.removeEmptyValues(filters);
        store[key] = filters;
        await super.store(this.FILTERS_KEY, store);
    }

    public async getFilters(key: string) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        return store[key] || {};
    }

    public async removeFilter(key: string) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        delete store[key];
        await super.store(this.FILTERS_KEY, store);
    }

    public async clearFilterValue(key: string, filters: any) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        this.removeEmptyValues(filters);
        store[key] = filters;
        await super.store(this.FILTERS_KEY, store);
    }

    private removeEmptyValues(filters: any) {
        Object.keys(filters).forEach((field: any) => {
            if (Array.isArray(filters[field]) ? filters[field].length === 0 : !filters[field]) {
                delete filters[field];
            }
        });
    }
}
