package com.javarush.command;

import com.javarush.constants.Constants;
import com.javarush.data.Result;
import com.javarush.data.ResultCode;

public class Exit extends BaseActions {
    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Constants.APPLICATION_CLOSED);
    }
}
