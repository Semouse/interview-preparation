package com.github.semouse.multithreading.syncronization.communication;

public class Example {
    public static void main(String[] args) {
        Process process = new Process();

        Thread first = new Thread(() -> {
            try {
                process.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread second = new Thread(() -> {
            try {
                process.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.start();
        second.start();
    }
}
