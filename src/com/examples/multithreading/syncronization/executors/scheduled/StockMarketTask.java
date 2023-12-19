package com.examples.multithreading.syncronization.executors.scheduled;

public class StockMarketTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading stock related data...");
    }
}
