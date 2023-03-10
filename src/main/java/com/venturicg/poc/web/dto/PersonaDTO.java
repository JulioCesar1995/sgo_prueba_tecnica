package com.venturicg.poc.web.dto;

import com.venturicg.poc.service.model.Pais;

public class PersonaDTO {
    private long id;
    private String nombres;
    private String apellidos;
    private PaisDTO pais;

    public PersonaDTO() {}

    public PersonaDTO(long id, String nombres, String apellidos, Pais pais) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais != null ? new PaisDTO(pais.getId(), pais.getNombre()) : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }
}
