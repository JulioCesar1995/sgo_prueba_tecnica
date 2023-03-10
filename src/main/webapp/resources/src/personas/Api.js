import BaseApi from "../commons/BaseApi";

export default class Api extends BaseApi {
    constructor(config) {
        super(config);
        this.baseEndpoint = `${config.context}/rest/persona`;
    }

    #getBaseEndPoint() {
        return this.baseEndpoint;
    }

    obtenerPersonas() {
        const url = this.#getBaseEndPoint();
        return Api.get(url);
    }

    insertarPersona(personaDTO) {
        const input = {
            url: this.#getBaseEndPoint(),
            data: personaDTO
        };
        return Api.post(input);
    }

    editarPersona(personaDTO) {
        const input = {
            url: this.#getBaseEndPoint(),
            data: personaDTO
        };
        return Api.put(input);
    }

    eliminarPersona(idPersona) {
        const input = {
            url: `${this.#getBaseEndPoint()}/${idPersona}`
        };
        return Api.delete(input);
    }
}
