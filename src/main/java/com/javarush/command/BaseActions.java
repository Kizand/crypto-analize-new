
package com.javarush.command;

import com.javarush.constants.Constants;
import com.javarush.data.Alphabet;
import com.javarush.data.Result;
import com.javarush.data.ResultCode;
import com.javarush.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class BaseActions implements Action {
    public Result transform(String sourceFileName, String destinationFileName, int key) {
        Path source = getPath(sourceFileName);
        Path destination = getPath(destinationFileName);

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(destination)) {
            int current;
            while ((current = reader.read()) > -1) {
                writer.write(getCharacter(current, key));
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        return new Result(ResultCode.OK, ".");
    }

    protected Path getPath(String fileName) {
        Path result = Path.of(fileName);
        return result.isAbsolute() ? result : Path.of(Constants.TXT_DIR + fileName);
    }

    protected char getCharacter(int current, int key) {
        char result = (char) current;
        int length = Alphabet.ALPHABET.length;
        if (Alphabet.index.containsKey(result)) {
            Integer index = Alphabet.index.get(result);
            if (key >= 0) {
                index = (index + key + length) % length;
            } else {
                index = (index + key + length * (1 - key / length)) % length;
            }
            result = Alphabet.ALPHABET[index];
        }
        return result;
    }
}