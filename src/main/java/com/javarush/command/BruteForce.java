package com.javarush.command;

import com.javarush.constants.Constants;
import com.javarush.data.Alphabet;
import com.javarush.data.Result;
import com.javarush.data.ResultCode;
import com.javarush.exception.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends BaseActions {
    @Override
    public Result execute(String[] parameters) {
        String sourceFileName = parameters[0];
        String destinationFileName = parameters[1];
        int maxCount = 0;
        int bestKey = 0;
        char checkChar = ' ';
        for (int i = 1; i < Alphabet.ALPHABET.length; ++i) {
            int currentCount = getCharCount(sourceFileName, i, checkChar);
            maxCount = Math.max(maxCount, currentCount);
            bestKey = (maxCount == currentCount) ? i : bestKey;
        }
        Result result = transform(sourceFileName, destinationFileName, bestKey);
        return new Result(ResultCode.OK, Constants.BRUTE_FORCE_COMPLETED + result.message());
    }

    public int getCharCount(String sourceFileName, int key, char character) {
        Path source = getPath(sourceFileName);
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(source)) {
            int current;
            while ((current = reader.read()) > -1) {
                if (getCharacter(current, key) == character) {
                    ++count;
                }
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        return count;
    }
}
