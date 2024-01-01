package com.examples.concurrency.map;

import java.util.concurrent.ConcurrentMap;

public class Consumer implements Runnable {
    private final ConcurrentMap<String, Integer> map;

    public Consumer(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("B"));
            Thread.sleep(1000);
            System.out.println(map.get("C"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
