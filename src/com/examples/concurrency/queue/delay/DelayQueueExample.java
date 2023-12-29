package com.examples.concurrency.queue.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Task> queue = new DelayQueue<>();

        try {
            queue.put(new Task(2000, "This is the first message..."));
            queue.put(new Task(10000, "This is the second message..."));
            queue.put(new Task(4500, "This is the third message..."));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!queue.isEmpty()){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
