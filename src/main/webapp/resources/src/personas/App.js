import '../scss/styles.scss';
// eslint-disable-next-line no-unused-vars
import bootstrap from 'bootstrap';
import $ from "jquery";

import Api from "./Api";
import ApiPaises from "../paises/Api";
import Personas from "./Personas";
import {showError} from "../commons/Utils";

export default class App {
    constructor(config) {
        this.api = new Api(config);
        this.apiPaises = new ApiPaises({ context: "" });
        this.personas = new Personas({ idTablaPersonas: 'tablePersonas', api: this.api, ...config });
        this.renderPersonas();
        this.obtenerPaises();
        this.listaPersonas = [];
        this.personaUpdate = {};
    }

    renderPersonas() {
        this.api.obtenerPersonas()
            .then(personas => {
                this.personas.render(personas);
                this.listaPersonas = personas;
            })
            .catch(error => {
                showError(error);
            });
    }

    obtenerPaises() {
        this.apiPaises.obtenerPaises()
            .then(paises => {
                const paisSelector = $('#paisPersona');
                paises.forEach(p => {
                    paisSelector.append(new Option(p.nombre, p.id));
                });
            })
            .catch(error => {
                showError(error);
            });
    }

    eliminarPersona(idPersona) {
        this.api.eliminarPersona(idPersona)
            .then(respuesta => {
                console.log(respuesta);
                $(`table tr[id=${idPersona}]`).remove();
            })
            .catch(error => {
                showError(error);
            });
    }

    mostrarModalEditarPersona(idPersona) {
        this.personaUpdate = this.listaPersonas.find(p => p.id === idPersona);
        $('#modalAgregarEditarPersonaLabel').text('Editar Persona');
        $('#accionPersona').val('editar');
        $('#idPersona').val(this.personaUpdate.id);
        $('#nombresPersona').val(this.personaUpdate.nombres);
        $('#apellidosPersona').val(this.personaUpdate.apellidos);
        $('#paisPersona').val(this.personaUpdate.pais ? this.personaUpdate.pais.id : null);
        $('#modalAgregarEditarPersona').modal('show');
    }

    mostrarModalAgregarPersona(){
        $('#modalAgregarEditarPersonaLabel').text('Agregar Persona');
        $('#accionPersona').val('agregar');
        $('#idPersona').val('');
        $('#nombresPersona').val('');
        $('#apellidosPersona').val('');
        $('#paisPersona').val('');
        $('#modalAgregarEditarPersona').modal('show');
    }

    editarAgregarPersona(accion, idPersona) {
        if(accion === 'editar') {
            const persona = {
                id: idPersona,
                nombres: $('#nombresPersona').val(),
                apellidos: $('#apellidosPersona').val(),
                pais: { id: $('#paisPersona').val() }
            };
            this.api.editarPersona(persona)
                .then(respuesta => {
                    console.log(respuesta);
                    window.location.reload();
                })
                .catch(error => {
                    showError(error);
                });
        } else {
            const persona = {
                nombres: $('#nombresPersona').val(),
                apellidos: $('#apellidosPersona').val(),
                pais: { id: $('#paisPersona').val() }
            };
            this.api.insertarPersona(persona)
                .then(respuesta => {
                    console.log(respuesta);
                    window.location.reload();
                })
                .catch(error => {
                    showError(error);
                });
        }
    }
}

// eslint-disable-next-line no-undef
globalThis.app = new App(config);
