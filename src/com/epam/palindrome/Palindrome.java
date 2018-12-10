package com.epam.palindrome;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder(word);
        System.out.println("Is palindrome = " + word.equals(stringBuilder.reverse().toString()));
    }
}
