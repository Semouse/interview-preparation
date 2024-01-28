package com.examples.streams.parallelization.sum;

import java.util.stream.LongStream;

public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(sum(1000000000));
        System.out.println("Sum taken: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(parallelSum(1000000000));
        System.out.println("Parallel sum taken: " + (System.currentTimeMillis() - start));
    }

    private static long sum(long n){
        return LongStream.range(0, n).reduce(0L, Long::sum);
    }

    private static long parallelSum(long n){
        return LongStream.range(0, n).parallel().reduce(0L, Long::sum);
    }
}
