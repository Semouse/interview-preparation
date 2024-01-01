package com.examples.concurrency.map;

import java.util.concurrent.ConcurrentMap;

public class Producer implements Runnable {

    private final ConcurrentMap<String, Integer> map;

    public Producer(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }


    @Override
    public void run() {
        try {
            map.put("A", 1000);
            Thread.sleep(1000);
            map.put("B", 2000);
            Thread.sleep(1000);
            map.put("C", 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
