package com.examples.concurrency.queue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {

    private final long duration;
    private final String message;

    public long getDuration() {
        return duration;
    }

    public String getMessage() {
        return message;
    }

    public Task(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.duration, ((Task) o).getDuration());
    }
}
