package com.examples.parallelization.forkjoin.task.max;

public class SequentialMaxFinding implements MaxFinder {

    @Override
    public long max(long[] numbers) {
        long max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        return max;
    }
}
