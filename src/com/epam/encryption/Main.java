package com.epam.encryption;

import static com.epam.encryption.File.*;
import static com.epam.encryption.Encryption.*;

public class Main {
    public static void main(String[] args) {
        String key = generateKey(6);
        writeFile(encode(readFile("default.txt"), key),"coded.txt");
        writeFile(decode(readFile("coded.txt"), key), "decoded.txt");
    }
}
