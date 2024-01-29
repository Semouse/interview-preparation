package com.github.semouse.memes;


import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to enter two numbers separated by space
 * Programs call specific method to find greatest common divisor.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter two numbers separated by space: ");
        String input = in.nextLine();

        String[] arguments = input.split("\\s+");
        System.out.println(gcd(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
    }

    public static int gcd(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber % secondNumber);
    }
}
