package com.examples.multithreading.syncronization.visibility;

public class Volatile {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread first = new Thread(worker);

        first.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}
