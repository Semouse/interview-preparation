package com.examples.concurrency.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
