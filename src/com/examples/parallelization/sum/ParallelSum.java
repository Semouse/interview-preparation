package com.examples.parallelization.sum;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelSum implements Summer {
    private final ParallelWorker[] workers;
    private final int numberOfThreads;

    public ParallelSum(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.workers = new ParallelWorker[numberOfThreads];
    }

    @Override
    public int sum(int[] numbers) {
        int size = (int) Math.ceil(numbers.length * 1.0 / numberOfThreads);
        IntStream.range(0, numberOfThreads).forEach(i -> {
            workers[i] = new ParallelWorker(numbers, i * size, (i + 1) * size);
            workers[i].start();
        });

        try {
            for (ParallelWorker worker : workers) {
                worker.join();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return Arrays.stream(workers).mapToInt(ParallelWorker::getPartialSum).sum();
    }
}
