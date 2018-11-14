package com.epam.encryption;

import java.io.*;

public class File {
    public static String readFile(String filaname) {
        StringBuilder dataFromFile = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filaname))) {
            while ((line = bufferedReader.readLine()) != null) {
                dataFromFile.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile.toString();
    }

    public static void writeFile(String text, String filename) {
        try (BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(filename))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
