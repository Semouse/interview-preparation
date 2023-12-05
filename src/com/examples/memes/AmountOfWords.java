package com.examples.memes;

import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to enter text.
 * Program calls specific function which take one parameter of String type and returns amount of words in the text.
 * Program prints amount of words to the console.
 */

public class AmountOfWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter any text: ");
        int amountOfWords = getWordsAmount(in.nextLine());
        System.out.println("Amount of words in your text: " + amountOfWords);
    }

    private static int getWordsAmount(String text) {
        return text.split(" ").length;
    }
}
