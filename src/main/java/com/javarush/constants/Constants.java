package com.javarush.constants;

import java.io.File;
import java.nio.file.Paths;

public interface Constants {
    String TXT_DIR = Paths.get(System.getProperty("user.dir"), "text").toString() + File.separator;
    String APPLICATION_CLOSED = "Application closed";
    String ENCRYPT_COMPLETED = "Encrypt completed";
    String DECRYPT_COMPLETED = "Decrypt completed";
    String BRUTE_FORCE_COMPLETED = "BruteForce completed";

}
