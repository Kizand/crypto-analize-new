package com.javarush.view;

import com.javarush.controller.MainController;
import com.javarush.data.Result;

import java.util.Arrays;

public class ConsoleApp {
    private final MainController controller;
    private final Menu menu;

    public ConsoleApp(MainController controller, Menu menu) {
        this.controller = controller;
        this.menu = menu;
    }

    private Result getResult(String[] args) {
        String actionName = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return controller.exceptionAction(actionName, parameters);
    }

    public void run(String[] args) {
        if (args.length == 0) {
            args = menu.getArgs();
        }
        Result result = getResult(args);
        System.out.println(result);
    }
}
