package com.github.semouse.multithreading.syncronization.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Example {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread firstThread = new Thread(Example::increment, "firstThread");
        Thread secondThread = new Thread(Example::increment, "secondThread");

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter is: " + counter);
    }

    private static void increment() {
        IntStream.range(0, 10000).forEach(i -> counter.incrementAndGet());
    }
}
