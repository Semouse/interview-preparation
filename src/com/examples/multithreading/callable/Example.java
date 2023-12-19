package com.examples.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {
    public static void main(String[] args) {
        int n = 5;
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = IntStream.range(0, n)
                .mapToObj(i -> service.submit(new Task(i + 1)))
                .collect(Collectors.toCollection(() -> new ArrayList<>(n)));
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
    }
}
