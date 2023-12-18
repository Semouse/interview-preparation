package com.examples.multithreading.syncronization.communication;

public class Process {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again in the produce method...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Consume method is executed");
            notify();
        }
    }
}
