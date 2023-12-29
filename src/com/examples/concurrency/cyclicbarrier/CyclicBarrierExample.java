package com.examples.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("All task have been finished"));
        IntStream.range(0, 5).forEach(i -> service.execute(new Task(i, barrier)));
        service.shutdown();
    }
}
