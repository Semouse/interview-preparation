package com.examples.memes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to enter random words separated by space
 * Program asks user to enter minimum length of string to filter words which were entered
 * Program creates array object from entered words
 * Program calls specific method which takes String[] as a parameter and returns array of strings which contains words that have length more or equal to value specified by user
 */
public class FilterStringArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter any words separated by space: ");
        String userInput = in.nextLine();
        System.out.print("Please, enter minumum word length to filter words: ");
        int minLength = in.nextInt();
        String[] words = userInput.split("\\s+");
        String[] filteredWords = filterWordsByLength(minLength, words);
        System.out.println(Arrays.toString(filteredWords));
    }

    public static String[] filterWordsByLength(int minLength, String[] words) {
        return Arrays.stream(words).filter(word -> word.length() >= minLength).toArray(String[]::new);
    }
}
