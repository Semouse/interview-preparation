package com.github.semouse.multithreading.creation;

import java.util.stream.IntStream;

public class Walker extends Thread {

    private final int number;

    public Walker(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "Walker " + number + " : " + i).forEach(System.out::println);
    }
}
