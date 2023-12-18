package com.examples.multithreading.syncronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//Solution - remove cyclic dependency: reorder lock acquiring.
public class Deadlock {
    private final Lock firstLock = new ReentrantLock(true);
    private final Lock secondLock = new ReentrantLock(true);

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        new Thread(deadlock::firstWorker, "firstWorker").start();
        new Thread(deadlock::secondWorker, "secondWorker").start();
    }

    public void firstWorker() {
        firstLock.lock();
        System.out.println("First worker acquires the first lock...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        secondLock.lock();
        System.out.println("First worker acquires the second lock...");

        firstLock.unlock();
        secondLock.unlock();
    }

    public void secondWorker() {
        secondLock.lock();
        System.out.println("Second worker acquires the second lock...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstLock.lock();
        System.out.println("Second worker acquires the first lock...");

        firstLock.unlock();
        secondLock.unlock();
    }
}
