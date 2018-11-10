package com.epam.text;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String DEFAULT_TEXT = "Hello!";
    private static final String DEFAULT_FILENAME = "default.txt";

    public static void main(String[] args) {
        boolean success = false;
        String filename = "input.txt";
        Scanner scanner = new Scanner(System.in);
        String outputString = null;

        do {
            try {
                StringBuilder stringBuilder = readFile(filename);
                System.out.print("Введите дополнительный текст: ");
                stringBuilder.append(scanner.nextLine());
                outputString = stringBuilder.toString();
                success = writeFile(stringBuilder.reverse().toString());
            } catch (FileNotFoundException e) {
                filename = createFile();
            }
        } while (!success);

        System.out.println(outputString.toUpperCase());
        System.out.println(outputString.toLowerCase());
        System.out.println(outputString.substring(outputString.length() / 3, (outputString.length() / 3) * 2));
        outputSpecial(outputString);
    }

    private static void outputSpecial(String outputString) {
        //String[] tokens = outputString.split("\\W");
        String[] tokens = outputString.split("[-. !?]");
        for (String token : tokens) {
            if ( !token.equals("") ) {
                String tokenWithUpperCase = token.toUpperCase();
                char lastChar = tokenWithUpperCase.charAt(token.length()-1);
//                String lastStrChar = token.substring(token.length() - 1).toUpperCase();
//                char lastChar = lastStrChar.toCharArray()[lastStrChar.length() - 1];
                if ( lastChar == 1040 || lastChar == 65 ) {
                    System.out.println(token);
                }
            }
        }
    }

    private static StringBuilder readFile(String filename) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(filename);
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ( (line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder;
    }

    private static String createFile() {
        String filename = DEFAULT_FILENAME;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            bufferedWriter.write(DEFAULT_TEXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filename;
    }

    private static boolean writeFile(String text) {
        boolean success = false;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            bufferedWriter.write(String.valueOf(text));
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }
}
