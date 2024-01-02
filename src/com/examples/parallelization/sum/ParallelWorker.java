package com.examples.parallelization.sum;

import java.util.stream.IntStream;

public class ParallelWorker extends Thread {

    private int[] numbers;
    private int low;
    private int high;

    private int partialSum;

    public ParallelWorker(int[] numbers, int low, int high) {
        super();
        this.numbers = numbers;
        this.low = low;
        this.high = Math.min(numbers.length, high);
    }

    @Override
    public void run() {
        partialSum = 0;
        IntStream.range(low, high).forEach(i -> partialSum += numbers[i]);
    }

    public int getPartialSum() {
        return partialSum;
    }
}
