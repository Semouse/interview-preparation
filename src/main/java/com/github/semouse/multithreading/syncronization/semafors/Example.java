package com.github.semouse.multithreading.syncronization.semafors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Example {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 12).forEach(i -> service.execute(Downloader.INSTANCE::download));
    }
}
