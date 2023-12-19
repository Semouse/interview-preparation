package com.examples.multithreading.syncronization.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class FixedThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.range(0, 100).forEach(i -> service.execute(new Task(i)));
        service.shutdown();
    }
}
