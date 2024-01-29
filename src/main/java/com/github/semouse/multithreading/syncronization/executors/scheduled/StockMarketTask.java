package com.github.semouse.multithreading.syncronization.executors.scheduled;

public class StockMarketTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading stock related data...");
    }
}
