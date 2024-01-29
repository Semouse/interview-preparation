package com.github.semouse.parallelization.forkjoin.action.mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortAction extends RecursiveAction {
    private final int[] numbers;

    public MergeSortAction(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    protected void compute() {
        if(numbers.length <= 10){
            mergeSort(numbers);
            return;
        }
        int middle = numbers.length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, numbers.length);
        invokeAll(new MergeSortAction(left), new MergeSortAction(right));
        merge(left, right, numbers);
    }

    private void mergeSort(int[] numbers) {
        if(numbers.length <= 1){
            return;
        }
        int middle = numbers.length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, numbers.length);
        mergeSort(left);
        mergeSort(right);

        merge(left, right, numbers);
    }

    private void merge(int[] leftSubarray, int[] rightSubarray, int[] originalArray) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSubarray.length && j < rightSubarray.length) {
            if (leftSubarray[i] < rightSubarray[j])
                originalArray[k++] = leftSubarray[i++];
            else
                originalArray[k++] = rightSubarray[j++];
        }

        while (i < leftSubarray.length)
            originalArray[k++] = leftSubarray[i++];

        while (j < rightSubarray.length)
            originalArray[k++] = rightSubarray[j++];
    }


}
