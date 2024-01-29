package com.github.semouse.multithreading.syncronization.semafors;

import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;

public enum Downloader {
    INSTANCE;

    private final Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
