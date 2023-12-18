package com.examples.multithreading.syncronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Example {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread first = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread second = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
