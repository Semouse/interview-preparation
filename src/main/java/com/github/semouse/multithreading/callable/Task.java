package com.github.semouse.multithreading.callable;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(2000);
        return "id: " + id;
    }
}
