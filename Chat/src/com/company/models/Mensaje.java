package com.company.models;

import com.company.utils.Sorteo;

import java.time.Instant;

public class Mensaje {
    private Instant hora;
    private String cuerpo;

    public Mensaje(){
        hora = Instant.now();
        setCuerpo(cuerpo);
    }
    public Mensaje(String cuerpo) {
        hora = Instant.now();
        setCuerpo(cuerpo);
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }


}
