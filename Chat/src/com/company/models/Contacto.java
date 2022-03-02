package com.company.models;

import com.company.utils.Sorteo;

import java.util.ArrayList;

public class Contacto {
    private String nombreAsignado;
    private String nombreUsuario;
    private boolean esPremium;
    private final ArrayList<Mensaje> mensajesEnviados;
    private final ArrayList<Mensaje> mensajesRecibidos;
    private final ArrayList<Mensaje> mensajesEliminados;


    public Contacto(String nombreAsignado, String nombreUsuario) {
        this.nombreAsignado = nombreAsignado;
        this.nombreUsuario = nombreUsuario;
        esPremium = premiumRandom();
        mensajesEnviados = new ArrayList<Mensaje>();
        mensajesRecibidos = new ArrayList<Mensaje>();
        mensajesEliminados = new ArrayList<Mensaje>();
    }

    public Contacto() {
        setNombreAsignado(nombreAsignado);
        setNombreUsuario(nombreUsuario);
        esPremium = premiumRandom();
        mensajesEnviados = new ArrayList<Mensaje>();
        mensajesRecibidos = new ArrayList<Mensaje>();
        mensajesEliminados = new ArrayList<Mensaje>();

    }

    public ArrayList<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public ArrayList<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public ArrayList<Mensaje> getMensajesEliminados() {
        return mensajesEliminados;
    }

    public String getNombreAsignado() {
        return nombreAsignado;
    }

    public void setNombreAsignado(String nombreAsignado) {
        this.nombreAsignado = nombreAsignado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean getEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    private boolean premiumRandom(){
        int probabilidad = Sorteo.numeroAleatorio(0,100);
        boolean contactoEsPremium = false;
        if(probabilidad>=0 && probabilidad<=50) {
            contactoEsPremium = true;
        }
        return contactoEsPremium;
    }
}
