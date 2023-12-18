package com.examples.multithreading.creation;


public class Example {
    public static void main(String[] args) {
        Thread first = new Thread(new Runner(1));
        Thread second = new Thread(new Runner(2));

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
