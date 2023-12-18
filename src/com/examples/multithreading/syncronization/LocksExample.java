package com.examples.multithreading.syncronization;

import java.util.stream.IntStream;

public class LocksExample {
    public static int firstCounter;
    public static int secondCounter;

    private static final Object firstLock = new Object();
    private static final Object secondLock = new Object();

    public static void incrementFirst() {
        synchronized (firstLock) {
            firstCounter++;
        }
    }

    public static void incrementSecond() {
        synchronized (secondLock) {
            secondCounter++;
        }
    }

    public static void process() {
        Thread first = new Thread(() -> IntStream.range(0, 100).forEach(i -> incrementFirst()));
        Thread second = new Thread(() -> IntStream.range(0, 100).forEach(i -> incrementSecond()));
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The first counter is: " + firstCounter);
        System.out.println("The second counter is: " + secondCounter);
    }

    public static void main(String[] args) {
        process();
    }
}
