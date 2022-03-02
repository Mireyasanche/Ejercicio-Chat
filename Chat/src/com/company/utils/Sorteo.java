package com.company.utils;

public class Sorteo {
    public static int numeroAleatorio(int max, int min){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static String mensajeRandom(){
        String[] mensajes = {"Buenos días.", "Buenas noches.", "Buenas tardes." , "Sí.", "No.", "Hola.", "Adiós.", "Bien.", "Mal."};
        return mensajes[Sorteo.numeroAleatorio(0,mensajes.length)];
    }
    public static boolean probabilidad (int nuumero){
        boolean isTrue = true;
        if(numeroAleatorio(0,100)<=60){
            isTrue = true;
        }else{
            isTrue = false;
        }
        return isTrue;
    }
}
