package com.github.semouse.memes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to input integer numbers separated by space.
 * Program creates array object with entered numbers.
 * Program calls specific method which takes int[] as an parameter and returns max value in this array
 */
public class FindMaxInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter integer numbers separated by space: ");
        String numbers = in.nextLine();
        int[] intArray = parseString(numbers);
        System.out.println("*** Initial Array ***");
        System.out.println(Arrays.toString(intArray));
        int maxInt = findMaxIntInArray(intArray);
        System.out.println("*** Max number in array ***");
        System.out.println(maxInt);
    }

    public static int[] parseString(String numbers) {
        return Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int findMaxIntInArray(int[] intArray) {
        return Arrays.stream(intArray).max().orElse(-1);
    }
}
