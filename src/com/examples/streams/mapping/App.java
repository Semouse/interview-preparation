package com.examples.streams.mapping;

import java.util.Arrays;
import java.util.List;

/**
 * Given two lists of numbers ([1, 2, 3], [4, 5]). Generate all pairs of possible numbers!
 */
public class App {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> values = Arrays.asList(4, 5);

        List<List<Integer>> pairs = numbers.stream()
                .flatMap(i -> values.stream().map(j -> Arrays.asList(i, j)))
                .toList();
        System.out.println(Arrays.toString(pairs.toArray()));
    }
}
