package com.github.semouse.parallelization.forkjoin.action.mergesort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class App {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] numbers = generateNumbers(10000000);
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortAction(numbers));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static int[] generateNumbers(int n) {
        return IntStream.range(0, n).map(i -> random.nextInt()).toArray();
    }
}
