package com.examples.multithreading.syncronization.producerconsumer;

public class App {
    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread first = new Thread(() -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread second = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        first.start();
        second.start();
    }
}
