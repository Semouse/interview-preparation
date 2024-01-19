package com.examples.parallelization.forkjoin.action.integers;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PrinterRecursiveAction action = new PrinterRecursiveAction(List.of(1, 2, 3, 4, 5, 6));
        action.invoke();
    }
}
