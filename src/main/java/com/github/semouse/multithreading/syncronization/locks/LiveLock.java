package com.github.semouse.multithreading.syncronization.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock firstLock = new ReentrantLock(true);
    private final Lock secondLock = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock livelock = new LiveLock();
        new Thread(livelock::firstWorker, "firstWorker").start();
        new Thread(livelock::secondWorker, "secondWorker").start();
    }

    private void firstWorker() {
        while (true) {
            try {
                firstLock.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("First worker acquires the firstLock...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("First worker tries to get secondLock...");
            if (secondLock.tryLock()) {
                System.out.println("First worker acquires the secondLock...");
                secondLock.unlock();
            } else {
                System.out.println("First worker can not acquire secondLock...");
                continue;
            }
            break;
        }
    }

    private void secondWorker() {
        while (true) {
            try {
                secondLock.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("Second worker acquires the secondLock...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second worker tries to get firstLock...");
            if (firstLock.tryLock()) {
                System.out.println("Second worker acquires the firstLock...");
                firstLock.unlock();
            } else {
                System.out.println("Second worker can not acquire firstLock...");
                continue;
            }
            break;
        }
    }
}
