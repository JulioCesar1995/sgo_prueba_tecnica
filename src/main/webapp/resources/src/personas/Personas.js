import DataTable from 'datatables.net';
import 'datatables.net-dt/css/jquery.dataTables.min.css';
import bootstrap from 'bootstrap';
import $ from "jquery";

export default class Personas {
    constructor(config) {
        this.api = config.api;
        this.idTablaPersonas = config.idTablaPersonas;
    }

    render(personas) {
        this.tablaPaises = new DataTable(`#${this.idTablaPersonas}`, {
            data: personas,
            autoWidth: true,
            responsive: true,
            language: {
                url: `${this.api.getContext()}/DataTables/i18n/es-CL.json`,
            },
            rowId: 'id',
            columns: [
                {
                    data: "id",
                    render: (data, type, row) => data
                },
                {
                    data: "nombres",
                    render: (data, type, row) => data
                },
                {
                    data: "apellidos",
                    render: (data, type, row) => data
                },
                {
                    data: "pais",
                    render(data, type, row) {
                    return data ? data.nombre : null;
                    }
                },
                {
                    data: "id",
                    render(data, type, row) {
                        return `<a class="btn btn-info btn-sm btnEditar" onclick="globalThis.app.mostrarModalEditarPersona(${data})">Editar</a>  `
                            + `<a class="btn btn-danger btn-sm btnEliminar" onclick="globalThis.app.eliminarPersona(${data})">Eliminar</a>`;
                    }
                }
            ],
            dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>'
        });
        globalThis.app.tablaPaises = this.tablaPaises;
    }
}
