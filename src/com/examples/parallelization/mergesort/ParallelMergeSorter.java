package com.examples.parallelization.mergesort;

import java.util.Arrays;

public class ParallelMergeSorter extends Sorter {
    private final int numberOfThreads;

    public ParallelMergeSorter(int[] numbers, int numberOfThreads) {
        super(numbers);
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void sort() {
        parallelMergeSort(0, numbers.length - 1, numberOfThreads);
    }

    private void parallelMergeSort(int low, int high, int numberOfThreads) {
        if (numberOfThreads == 1) {
            mergeSort(low, high);
            return;
        }

        int middle = (low + high) / 2;
        Thread left = createThread(low, middle, numberOfThreads);
        Thread right = createThread(middle + 1, high, numberOfThreads);

        left.start();
        right.start();

        try {
            left.join();
            right.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(low, middle, high);
    }

    private Thread createThread(int low, int high, int numberOfThreads) {
        return new Thread(() -> {
            parallelMergeSort(low, high, numberOfThreads / 2);
        });
    }
}
