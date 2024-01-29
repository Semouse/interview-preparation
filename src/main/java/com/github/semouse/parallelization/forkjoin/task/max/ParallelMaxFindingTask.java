package com.github.semouse.parallelization.forkjoin.task.max;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFindingTask extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int low;
    private final int high;

    public ParallelMaxFindingTask(long[] numbers, int low, int high) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {
        if (high - low < 5000) {
            return max();
        } else {
            int middle = (high + low) / 2;
            ParallelMaxFindingTask first = new ParallelMaxFindingTask(numbers, low, middle);
            ParallelMaxFindingTask second = new ParallelMaxFindingTask(numbers, middle, high);

            invokeAll(first, second);

            return Math.max(first.join(), second.join());
        }
    }

    private Long max() {
        long max = numbers[low];
        for (int i = low + 1; i < high; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }
}
