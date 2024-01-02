package com.examples.parallelization.mergesort;

import java.util.Arrays;

public class SequentialMergeSorter extends Sorter {

    public SequentialMergeSorter(int[] numbers) {
        super(numbers);
    }

    @Override
    public void sort() {
        mergeSort(0, numbers.length - 1);
    }
}
