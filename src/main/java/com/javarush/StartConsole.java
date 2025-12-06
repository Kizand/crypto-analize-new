package com.javarush;

import com.javarush.controller.MainController;
import com.javarush.view.ConsoleApp;
import com.javarush.view.Menu;

import java.util.Scanner;

public class StartConsole {

    static void main(String[] args) {
        MainController controller = new MainController();
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        ConsoleApp app = new ConsoleApp(controller, menu);
        app.run(args);
    }
}
