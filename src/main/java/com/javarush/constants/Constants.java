package com.javarush.constants;

import java.io.File;

public interface Constants {
    String TXT_DIR = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    String APPLICATION_CLOSED = "Application closed";
    String ENCRYPT_COMPLETED = "Encrypt completed";
    String DECRYPT_COMPLETED = "Decrypt completed";
    String BRUTE_FORCE_COMPLETED = "BruteForce completed";

}
