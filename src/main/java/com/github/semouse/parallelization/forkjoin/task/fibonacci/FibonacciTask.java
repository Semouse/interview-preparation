package com.github.semouse.parallelization.forkjoin.task.fibonacci;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1){
            return n;
        } else {
            FibonacciTask first = new FibonacciTask(n - 1);
            FibonacciTask second = new FibonacciTask(n - 2);
            second.fork();
            return first.compute() + second.join();
        }
    }
}
