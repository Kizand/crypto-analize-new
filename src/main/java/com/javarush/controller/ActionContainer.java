package com.javarush.controller;

import com.javarush.command.*;
import com.javarush.exception.AppException;

public enum ActionContainer {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTEFORCE(new BruteForce()),
    EXIT(new Exit());

    private final Action action;

    ActionContainer(Action action) {
        this.action = action;
    }

    public static Action getAction(String actionName) {
        ActionContainer value;
        try {
            value = ActionContainer.valueOf(actionName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new AppException(String.format("Action %s not found", actionName), e);
        }
        return value.action;
    }
}
