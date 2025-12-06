package com.javarush.controller;

import com.javarush.command.Action;
import com.javarush.data.Result;
import com.javarush.data.ResultCode;
import com.javarush.exception.AppException;

public class MainController {
    public Result exceptionAction(String actionName, String[] parameters) {
        Action action = ActionContainer.getAction(actionName);
        try {
            return action.execute(parameters);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}