package com.examples.parallelization.mergesort;

import java.util.Arrays;

public abstract class Sorter implements Sortable {
    protected final int[] numbers;
    protected final int[] temp;

    protected Sorter(int[] numbers) {
        this.numbers = numbers;
        this.temp = new int[numbers.length];
    }

    public void show() {
        Arrays.stream(numbers).forEach(System.out::println);
    }

    protected void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }

        int middleIndex = (low + high) / 2;
        mergeSort(low, middleIndex);
        mergeSort(middleIndex + 1, high);

        merge(low, middleIndex, high);
    }

    protected void merge(int low, int middleIndex, int high) {
        if (high + 1 - low >= 0) System.arraycopy(numbers, low, temp, low, high + 1 - low);

        int i = low;
        int k = low;
        int j = middleIndex + 1;
        while (i <= middleIndex && j <= high) {
            if (temp[i] < temp[j]) {
                numbers[k] = temp[i];
                i++;
            } else {
                numbers[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middleIndex) {
            numbers[k] = temp[i];
            i++;
            k++;
        }

        while (j <= high) {
            numbers[k] = temp[j];
            j++;
            k++;
        }
    }

}
