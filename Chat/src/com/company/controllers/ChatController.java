package com.company.controllers;

import com.company.models.Contacto;
import com.company.models.Mensaje;
import com.company.utils.Color;
import com.company.utils.Input;
import com.company.utils.Sorteo;

import java.util.ArrayList;

public class ChatController {
    private boolean esPremium;

    private final ArrayList<Contacto> contactos;

    Input input = new Input();

    public ChatController() {
        esPremium = false;
        contactos = new ArrayList<Contacto>();

    }

    public boolean getEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void crearContacto(String nombreContacto, String nombreUsuario){
        Contacto contacto =  new Contacto(nombreContacto,nombreUsuario);
        contactos.add(contacto);
    }

    public void eliminarContacto(String nombreContacto){
        for(int i = 0; i<contactos.size(); i++){
            if(nombreContacto.equalsIgnoreCase(contactos.get(i).getNombreAsignado())){
                contactos.remove(i);
            }else{
                System.out.println(Color.RED + "No se ha encontrado ningún contacto con ese nombre." + Color.RESET);
            }
        }
    }

    public void hacertePremium(){
        System.out.println(Color.CYAN + "Deberá abonar un importe de 3,99€. ¿Desea continuar?" + Color.RESET);
        String entrada = input.readLine();
        if(controlarSiONo(entrada)){
            esPremium = true;
        }
    }

    public void imprimirContactos(){
        for(int i = 0; i <contactos.size(); i++){
            if(contactos.get(i) != null) {
                System.out.println(Color.CYAN_BOLD_BRIGHT + contactos.get(i).getNombreAsignado() + Color.RESET);
            }
        }
    }

    public void eliminarMensaje(Contacto contacto) {
        System.out.println(Color.CYAN + "¿Desea eliminar un nuevo mensaje?" + Color.RESET);
        String entrada = input.readLine();
        if(controlarSiONo(entrada)) {
            System.out.println(Color.CYAN + "Introduzca los 6 primeros caracteres del mensaje que desea eliminar" + Color.RESET);
            String caracteres = input.readLine();
            System.out.println(Color.CYAN + "Introduzca el contacto del que desea eliminarlo" + Color.RESET);
            String nombre = input.readLine();
            for(int i = 0; i<contacto.getMensajesEnviados().size(); i++) {
                String mensajeRecortado = contacto.getMensajesEnviados().get(i).getCuerpo().substring(0,5);
                if (caracteres.equalsIgnoreCase(mensajeRecortado)){
                    contacto.getMensajesEliminados().add(contacto.getMensajesEnviados().get(i));
                    contacto.getMensajesEnviados().remove(i);
                }
            }
        }
        System.out.println(Color.CYAN + "¿Desea recuperar el último mensaje?" + Color.RESET);
        entrada = input.readLine();
        if(controlarSiONo(entrada)){
            contacto.getMensajesRecibidos().add(contacto.getMensajesEliminados().get(contacto.getMensajesEliminados().size()-1));
            contacto.getMensajesEliminados().remove(contacto.getMensajesEliminados().get(contacto.getMensajesEliminados().size()-1));
        }
    }

    private boolean controlarSiONo(String entrada) {
        boolean isTrue = false;
        if (entrada.equalsIgnoreCase("si") || entrada.equalsIgnoreCase("sí") || entrada.equalsIgnoreCase("si.") || entrada.equalsIgnoreCase("sí.")) {
            isTrue= true;
        } else {
            System.out.println(Color.RED + "Se ha cancelado la operación" + Color.RESET);
        }
        return isTrue;
    }

    public void imprimirMensajesEliminados(Contacto contacto) {
        for(int i = 0; i <contacto.getMensajesEliminados().size(); i++){
            if(contacto.getMensajesEliminados().get(i) != null) {
                System.out.println(Color.CYAN_BOLD_BRIGHT + contacto.getMensajesEliminados().get(i).getCuerpo() + Color.RESET);
            }
        }
    }

    public void abrirChat(String entrada, Contacto contacto) {
        for(int i = 0; i <contacto.getMensajesEnviados().size(); i++){
            if(contacto.getMensajesEnviados().get(i) != null && contacto.getMensajesRecibidos().get(i) != null) {
                System.out.println("                                     " + Color.GREEN + contacto.getMensajesEnviados().get(i).getHora() +  ":" + contacto.getMensajesEnviados().get(i).getCuerpo() + Color.RESET);
                System.out.println(Color.GREEN_BOLD_BRIGHT + contacto.getMensajesEnviados().get(i).getHora() +  ":" + contacto.getMensajesRecibidos().get(i).getCuerpo() + Color.RESET);
            }
        }
    }

    public void logicaChat(Contacto contacto){
        System.out.println(Color.BLUE + "Escriba su nuevo mensaje:" + Color.RESET);
        Mensaje mensajeEnviado = new Mensaje(input.readLine());
        contacto.getMensajesEnviados().add(mensajeEnviado);
        System.out.println(Color.GREEN + mensajeEnviado.getHora() + ":" + mensajeEnviado.getCuerpo() + Color.RESET);
        Mensaje mensajeRecibido = new Mensaje();
        mensajeRecibido.setCuerpo(Sorteo.mensajeRandom());
        contacto.getMensajesRecibidos().add(mensajeRecibido);
        System.out.println(Color.GREEN_BOLD_BRIGHT + mensajeRecibido.getHora() + ":" + mensajeRecibido.getCuerpo() + Color.RESET);
        if(getEsPremium()){
            boolean seEliminaMensajeRecibido  = Sorteo.probabilidad(60);
            if(seEliminaMensajeRecibido){
                contacto.getMensajesRecibidos().remove(Sorteo.numeroAleatorio(0,contacto.getMensajesRecibidos().size()));
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
