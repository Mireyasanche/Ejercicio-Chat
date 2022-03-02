package com.company.controllers;

import com.company.utils.Color;
import com.company.utils.Input;

import java.time.Instant;

public class MenuController {
    public void imprimirMenu(ChatController chat){
        System.out.println(Color.PURPLE + "MENÚ:" + Color.RESET);
        chat.imprimirContactos();
        System.out.println(Color.BLUE + " 1." + Color.CYAN_BOLD_BRIGHT +" Crear contacto \n"
                        + Color.BLUE + " 2." + Color.CYAN_BOLD_BRIGHT + " Eliminar contacto "
        );
        opcionPremium(chat);

    }

    public void opcionPremium(ChatController chat){
        if(!chat.getEsPremium()){
            System.out.println( Color.BLUE + " 3." + Color.CYAN_BOLD_BRIGHT +" Hacerte Premium \n" + Color.RESET);
        }else{
            System.out.println(Color.BLUE + " 3." + Color.CYAN_BOLD_BRIGHT +" Mensajes eliminados \n" + Color.RESET);
        }
    }


    public void controlarEntradas(String entrada, ChatController chat){
        switch(entrada){
            case "1":
                chat.crearContacto(pedirCadena(Color.BLUE + "Inserte el nombre con el que quiere guardar el contacto."),pedirCadena("Inserte el usuario de su nuevo contacto.") + Color.RESET);
                break;
            case "2":
                chat.eliminarContacto(pedirCadena(Color.BLUE +"Inserte el nombre del contacto que desea eliminar") + Color.RESET);
                break;
            case "3":
                if(!chat.getEsPremium()){
                    chat.hacertePremium();
                }else{
                    chat.imprimirMensajesEliminados();
                    chat.eliminarMensaje();
                }
                break;
            default:
                for(int i = 0; i <chat.getContactos().size(); i++){
                    if(chat.getContactos().get(i).getNombreAsignado().equals(entrada)) {
                        chat.abrirChat(entrada);
                        chat.logicaChat();
                    }else{
                        System.out.println(Color.RED + "No ha elegido ninguna de las opciones disponibles en el menú." + Color.RESET);
                    }
                }
                break;
        }
    }

    public String pedirCadena(String mensaje){
        System.out.println(mensaje);
        Input input = new Input();
        return input.readLine();
    }
}
