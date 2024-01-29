package com.github.semouse.memes;

import java.util.Scanner;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to input height of the rectangle
 * After user inputs heights of the rectangle, program asks to input width of the rectangle.
 * Program calls specific method which takes two parameters of int type which prints rectangle to the console
 */
public class DrawEmptyRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter height of rectangle: ");
        int height = in.nextInt();
        System.out.print("Please, enter width of rectangle: ");
        int width = in.nextInt();

        drawRectangle(height, width);
    }

    public static void drawRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
