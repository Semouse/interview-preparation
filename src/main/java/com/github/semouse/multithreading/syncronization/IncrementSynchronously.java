package com.github.semouse.multithreading.syncronization;

import java.util.stream.IntStream;

public class IncrementSynchronously {

    public static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void process(){
        Thread first = new Thread(IncrementSynchronously::run);
        Thread second = new Thread(IncrementSynchronously::run);

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The counter is: " + counter);
    }

    public static void main(String[] args) {
        process();
    }

    private static void run() {
        IntStream.range(0, 100).forEach(i -> increment());
    }
}
