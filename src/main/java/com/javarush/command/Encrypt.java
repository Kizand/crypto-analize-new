package com.javarush.command;

import com.javarush.constants.Constants;
import com.javarush.data.Result;
import com.javarush.data.ResultCode;

public class Encrypt extends BaseActions {
    @Override
    public Result execute(String[] parameters) {
        String sourceFileName = parameters[0];
        String destinationFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        Result result = transform(sourceFileName, destinationFileName, key);
        return new Result(ResultCode.OK, Constants.ENCRYPT_COMPLETED + result.message());
    }
}
