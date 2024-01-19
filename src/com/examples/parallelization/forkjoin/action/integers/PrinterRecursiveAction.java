package com.examples.parallelization.forkjoin.action.integers;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class PrinterRecursiveAction extends RecursiveAction {

    private final List<Integer> values;

    public PrinterRecursiveAction(List<Integer> values) {
        this.values = values;
    }

    @Override
    protected void compute() {
        if (values.size() < 2) {
            values.forEach(System.out::println);
        } else {
            PrinterRecursiveAction left = new PrinterRecursiveAction(values.subList(0, values.size() / 2));
            PrinterRecursiveAction right = new PrinterRecursiveAction(values.subList(values.size() / 2, values.size()));

            invokeAll(left, right);
        }
    }
}
