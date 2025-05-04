package com.lavanderia.domain.entity;

public class Mensaje {
    private String infoMensaje;

    public Mensaje(String infoMensaje) {
        this.infoMensaje= infoMensaje;
    }

    public String getInfoMensaje() {
        return infoMensaje;
    }

    public void setInfoMensaje(String infoMensaje) {
        this.infoMensaje = infoMensaje;
    }
}
