package com.github.semouse.parallelization.sum;

import java.util.Random;
import java.util.stream.IntStream;

public class Application {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] numbers = createArray(1000000);

        SequentialSum sequentialSum = new SequentialSum();
        measure("sequential", sequentialSum, numbers);

        ParallelSum parallelSum = new ParallelSum(Runtime.getRuntime().availableProcessors());
        measure("parallel", parallelSum, numbers);
    }

    private static void measure(String type, Summer summer, int[] numbers) {
        long start = System.currentTimeMillis();
        System.out.println(summer.sum(numbers));
        long end = System.currentTimeMillis();
        System.out.printf("Time taken with %s approach: %6d ms%n", type, end - start);
    }

    private static int[] createArray(int n) {
        return IntStream.generate(() -> random.nextInt(n)).limit(n).toArray();
    }
}
