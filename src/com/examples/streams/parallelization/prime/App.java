package com.examples.streams.parallelization.prime;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long numberOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100).filter(App::isPrime).count();
        System.out.println("Number of primes: " + numberOfPrimes);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));


        start = System.currentTimeMillis();
        numberOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100).parallel().filter(App::isPrime).count();
        System.out.println("Number of primes: " + numberOfPrimes);
        System.out.println("Time taken parallel: " + (System.currentTimeMillis() - start));
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        long maxDivisor = (long) Math.sqrt(num);
        for (int i = 3; i <= maxDivisor; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
