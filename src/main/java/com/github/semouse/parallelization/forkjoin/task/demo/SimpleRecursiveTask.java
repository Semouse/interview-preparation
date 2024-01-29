package com.github.semouse.parallelization.forkjoin.task.demo;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private final int number;


    public SimpleRecursiveTask(int number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (number > 100) {
            System.out.println("Parallel execution split...");
            SimpleRecursiveTask first = new SimpleRecursiveTask(number / 2);
            SimpleRecursiveTask second = new SimpleRecursiveTask(number / 2);
            first.fork();
            second.fork();
            int subSolution = 0;
            subSolution += first.join();
            subSolution += second.join();
            return subSolution;
        } else {
            return 2 * number;
        }
    }
}
