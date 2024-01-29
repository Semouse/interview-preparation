package com.github.semouse.multithreading.syncronization.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        IntStream.range(0, 5).forEach(i -> service.execute(new Task(i)));
        service.shutdown();
    }
}
