package com.company;

import com.company.controllers.ChatController;
import com.company.controllers.MenuController;
import com.company.models.Contacto;
import com.company.utils.Color;
import com.company.utils.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(Color.BLUE_BOLD_BRIGHT + "PROGRAMA CHAT" + Color.RESET);
        ChatController chat = new ChatController();
        MenuController menu = new MenuController();
        Input input = new Input();

        boolean salir = false;
        do {
            menu.imprimirMenu(chat);
            String entrada = input.readLine();
                menu.controlarEntradas(entrada, chat);

        }while(!salir);
    }
}
