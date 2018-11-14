package com.epam.encryption;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Encryption {
    private static List<Character> symbols = new ArrayList<>();
    private static int symbolsCount;

    static {
        for (char symbol : ("ABCDFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdfghijklmnopqrstuvwxyz" +
                " 1234567890.,!?" +
                "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЭЮЯ" +
                "абвгдежзийклмнопрстуфхцчшщъьэюя").toCharArray()) {
            symbols.add(symbol);
        }
        symbolsCount = symbols.size();
    }

    public static String encode(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        for (char textSymbol : text.toCharArray()) {
            if ((keyIndex + 1) == key.length())
                keyIndex = 0;
            int encodedSymbolIndex = (symbols.indexOf(textSymbol) + symbols.indexOf(key.charAt(keyIndex))) % symbolsCount;
            result.append(symbols.get(encodedSymbolIndex));
            keyIndex++;
        }
        return result.toString();
    }

    public static String decode(String text, String key){
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        for (char textSymbol : text.toCharArray()) {
            if ((keyIndex + 1) == key.length())
                keyIndex = 0;
            int decodedSymbolIndex = (symbols.indexOf(textSymbol) +symbolsCount - symbols.indexOf(key.charAt(keyIndex))) % symbolsCount;
            result.append(symbols.get(decodedSymbolIndex));
            keyIndex++;
        }
        return result.toString();
    }

    static String generateKey(int length) {
        StringBuilder key = new StringBuilder();
        Random random = new Random(23);
        for (int i = 0; i < length; i++) {
            key.append(symbols.get(random.nextInt(symbolsCount)));
        }
        System.out.println(key);
        return key.toString();
    }
}
