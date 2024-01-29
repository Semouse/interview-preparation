package com.github.semouse.multithreading.syncronization.executors;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private final int id;
    private final Random random = new Random();

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id: " + id + " is in work in thread: " + Thread.currentThread().getName());

        long duration = random.nextLong(3);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
