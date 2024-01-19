package com.examples.parallelization.forkjoin.action.demo;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private final int counter;

    public SimpleRecursiveAction(int counter) {
        this.counter = counter;
    }

    @Override
    protected void compute() {
        if (counter > 100) {
            System.out.println("Parallel execution and split the tasks... " + counter);
            SimpleRecursiveAction first = new SimpleRecursiveAction(counter / 2);
            SimpleRecursiveAction second = new SimpleRecursiveAction(counter / 2);

            invokeAll(first, second);
        } else {
            System.out.println("The task is small enough to process...");
            System.out.println("The size of the task: " + counter);
        }
    }
}
