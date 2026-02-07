package com.javarush.command;

import com.javarush.data.Result;

public interface Action {
    Result execute(String[] parameters);
}