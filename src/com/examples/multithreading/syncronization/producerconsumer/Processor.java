package com.examples.multithreading.syncronization.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final List<Integer> list = new ArrayList<>();
    private int value;

    public void producer() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    wait();
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;
                    notifyAll();
                }

                Thread.sleep(1000);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (list.size() == LOWER_LIMIT){
                    System.out.println("Waiting for adding items...");
                    wait();
                } else {
                    System.out.println("Removing value: " + list.remove(list.size() - 1));
                    notifyAll();
                }

                Thread.sleep(1000);
            }
        }
    }
}
