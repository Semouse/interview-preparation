package com.github.semouse.memes.philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static com.github.semouse.memes.philosopher.Constants.*;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
        Chopstick[] chopsticks = IntStream.range(0, NUMBER_OF_CHOPSTICKS)
                .mapToObj(Chopstick::new)
                .toArray(Chopstick[]::new);

        try {
            IntStream.range(0, NUMBER_OF_PHILOSOPHERS).forEach(i -> {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUMBER_OF_CHOPSTICKS]);
                service.execute(philosophers[i]);
            });

            Thread.sleep(ACTION_INTERVAL_MS);

            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }
        } finally {
            service.shutdown();

            while (!service.isTerminated()) {
                Thread.sleep(1000);
            }
            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + " eat " + philosopher.getEatingCounter() + " times");
            }
        }

    }
}
