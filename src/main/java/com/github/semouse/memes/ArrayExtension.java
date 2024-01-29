package com.github.semouse.memes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Implement console program which will meet the following requirements:
 * Program starts and asks user to enter length of an array.
 * Program generates array of random integer numbers (use java.util.Random) with array length specified by user.
 * Program creates the second array with size of twice as much as the first array.
 * The first elements in the new array are first the same elements as in old array. The other half of elements are elements as in the first array multiplied by two.
 */
public class ArrayExtension {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter length of initial array: ");
        int baseArrayLength = in.nextInt();
        int[] arr = generateRandomArray(baseArrayLength);
        int[] extendedArray = extendArray(arr);
        System.out.println("*** Initial array ***");
        System.out.println(Arrays.toString(arr));
        System.out.println("*** Extended array ***");
        System.out.println(Arrays.toString(extendedArray));
    }

    /**
     * The method extends array.
     * If array {1, 2, 3} has been passed to this method then array {1, 2, 3, 2, 4, 6}
     * is returned from this method.
     *
     * @param arr - base of extension. Extended array contains elements from this array
     *            and additionally contains the same elements multiplied by two.
     * @return extended array.
     */
    public static int[] extendArray(int[] arr) {
        int[] destArr = Arrays.copyOf(arr, arr.length * 2);
        IntStream.range(arr.length, destArr.length).forEach(i -> destArr[i] = destArr[i - arr.length] * 2);
        return destArr;
    }

    public static int[] generateRandomArray(int amountOfElements) {
        return IntStream.range(0, amountOfElements).map(i -> random.nextInt(100)).toArray();
    }

}
