package com.github.semouse.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class First implements Runnable {
    private int counter;
    private final Exchanger<Integer> exchanger;

    public First(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter++;
            System.out.println("First incremented the counter: " + counter);

            try {
                counter = exchanger.exchange(counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
