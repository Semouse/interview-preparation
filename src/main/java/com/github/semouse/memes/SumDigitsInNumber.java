package com.github.semouse.memes;

import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to enter number
 * Program calls method which takes int as an argument and returns sum of all digits in this number.
 */
public class SumDigitsInNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter integer: ");
        int number = scanner.nextInt();

        int sumOfDigits = sumDigitsInNumber(number);
        System.out.println(sumOfDigits);
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        while(number != 0){
            sum+= number % 10;
            number /= 10;
        }

        return Math.abs(sum);
    }
}
