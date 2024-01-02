package com.examples.parallelization.sum;

import java.util.Arrays;

public class SequentialSum implements Summer {

    @Override
    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
