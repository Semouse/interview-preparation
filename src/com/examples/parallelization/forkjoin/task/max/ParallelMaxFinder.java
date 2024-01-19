package com.examples.parallelization.forkjoin.task.max;

import java.util.concurrent.ForkJoinPool;

public class ParallelMaxFinder implements MaxFinder {

    @Override
    public long max(long[] numbers) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new ParallelMaxFindingTask(numbers, 0, numbers.length));
    }
}
