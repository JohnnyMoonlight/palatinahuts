export const API_PATH = "/api/hut";

export default class API {
    constructor() {
    }

     
    static getHuts() {
        return Promise.resolve(this.getHutsRequest());
    }

    static async getHutsRequest() {
        let response = await fetch(API_PATH);
        let data = await response.json();
        this.huts = data;
        return data;
    }
    

    static async createHut(data, files) {
        let formData = new FormData();
        console.log(JSON.stringify(data));
        formData.append("hut",JSON.stringify(data));
        for (let file of files) {
            formData.append("image", file, file.name);
        }    

        let options = {
            method: "POST",
            body: formData,
        }

        return await fetch(API_PATH, options);
    }
}
