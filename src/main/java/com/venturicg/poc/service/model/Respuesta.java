package com.venturicg.poc.service.model;

public class Respuesta {
    private static final String MSG_EXITO = "Operacion realizada exitosamente";
    private String mensaje;

    Respuesta(String mensaje) {
        this.mensaje = mensaje;
    }

    public static Respuesta respuestaExitosa() {
        return new Respuesta(MSG_EXITO);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
