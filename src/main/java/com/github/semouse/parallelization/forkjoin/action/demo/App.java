package com.github.semouse.parallelization.forkjoin.action.demo;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SimpleRecursiveAction(200));
    }
}
