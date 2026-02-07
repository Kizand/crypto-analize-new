package com.javarush.data;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final char[] LETTERS = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static final char[] SYMBOLS = new char[]{'.', ',', '«', '»', '"', '\'', ':', ';', '!', '?', ' ', '<', '>'};
    private static final char[] NUMBERS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] ALPHABET = concatenateCharArrays(LETTERS, SYMBOLS, NUMBERS);
    public static final Map<Character, Integer> index = new HashMap();

    private static char[] concatenateCharArrays(char[]... arrays) {
        char[] entireLength = new char[LETTERS.length + SYMBOLS.length + NUMBERS.length];
        int currentIndex = 0;
        for(char[] array : arrays) {
            System.arraycopy(array, 0, entireLength, currentIndex, array.length);
            currentIndex += array.length;
        }
        return entireLength;
    }

    static {
        for(int i = 0; i < ALPHABET.length; ++i) {
            index.put(ALPHABET[i], i);
        }
    }
}
