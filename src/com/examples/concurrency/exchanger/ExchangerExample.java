package com.examples.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        First first = new First(exchanger);
        Second second = new Second(exchanger);

        new Thread(first).start();
        new Thread(second).start();
    }
}
