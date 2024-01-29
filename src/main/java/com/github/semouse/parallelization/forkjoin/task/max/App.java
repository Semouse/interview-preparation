package com.github.semouse.parallelization.forkjoin.task.max;

import java.util.Random;
import java.util.stream.IntStream;

public class App {
    private static final Random random = new Random();

    public static void main(String[] args) {
        long[] numbers = generateNumbers(10000000);
        MaxFinder sequential = new SequentialMaxFinding();
        measure(sequential, numbers);
        MaxFinder parallel = new ParallelMaxFinder();
        measure(parallel, numbers);
    }

    private static void measure(MaxFinder finder, long[] numbers) {
        System.out.println("Stats for " + finder.getClass().getSimpleName() + " approach");
        long start = System.currentTimeMillis();
        System.out.println("Max :" + finder.max(numbers));
        System.out.println("Time:" + (System.currentTimeMillis() - start));
    }

    private static long[] generateNumbers(int n) {
        return IntStream.range(0, n).mapToLong(i -> random.nextInt(1000)).toArray();
    }
}
