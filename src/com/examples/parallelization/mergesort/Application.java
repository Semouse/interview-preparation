package com.examples.parallelization.mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Application {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();

        int[] first = createArray(10000000);
        measure("parallel", new ParallelMergeSorter(first, processors));
        int[] second = Arrays.copyOf(first, first.length);
        measure("sequential", new SequentialMergeSorter(second));

    }

    private static void measure(String type, Sortable sort) {
        long start = System.currentTimeMillis();
        sort.sort();
        long end = System.currentTimeMillis();
        System.out.printf("Time taken with %s approach: %6d ms%n", type, end - start);
    }

    private static int[] createArray(int n) {
        return IntStream.generate(() -> random.nextInt(n)).limit(n).toArray();
    }
}
