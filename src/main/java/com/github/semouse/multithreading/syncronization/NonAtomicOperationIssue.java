package com.github.semouse.multithreading.syncronization;

public class NonAtomicOperationIssue {

    public static int counter = 0;
    public static void process() {
        Thread first = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter++;
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter++;
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

        System.out.println("Counter is: " + counter);
    }

    public static void main(String[] args) {
        process();
    }
}
