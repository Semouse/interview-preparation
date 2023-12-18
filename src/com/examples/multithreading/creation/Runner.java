package com.examples.multithreading.creation;

import java.util.stream.IntStream;

public class Runner implements Runnable {

    private final int number;

    public Runner(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "Runner " + number + " : " + i).forEach(System.out::println);
    }
}
