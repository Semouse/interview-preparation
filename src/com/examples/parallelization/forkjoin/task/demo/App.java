package com.examples.parallelization.forkjoin.task.demo;

import java.util.concurrent.ForkJoinPool;

/**
 * Double value in parallel manner;
 */
public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(200);
        System.out.println(pool.invoke(simpleRecursiveTask));
    }
}
