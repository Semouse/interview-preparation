package com.github.semouse.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private final int id;

    private final CountDownLatch latch;

    public Task(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        process();
        latch.countDown();
    }

    private void process() {
        try {
            System.out.println("Task with id: " + id + " is processing...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
