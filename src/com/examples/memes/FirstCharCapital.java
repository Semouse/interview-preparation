package com.examples.memes;

import java.util.Scanner;

public class FirstCharCapital {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter any text: ");
        String userInput = in.nextLine();


        System.out.println(firstCharToTitleCase(userInput));
    }

    public static String firstCharToTitleCase(String string) {
        char[] charArray = string.toLowerCase().toCharArray();
        boolean isFirstLetterFound = false;
        for (int i = 0; i < charArray.length; i++) {
            if (!isFirstLetterFound && Character.isLetter(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
                isFirstLetterFound = true;
            } else if (Character.isWhitespace(charArray[i])) {
                isFirstLetterFound = false;
            }
        }

        return String.valueOf(charArray);
    }
}
