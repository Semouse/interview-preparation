package com.github.semouse.memes.students;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private final int id;
    private final Lock lock;

    public Book(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException {
        if (lock.tryLock(5, TimeUnit.SECONDS)) {
            System.out.println(student + " starts reading " + this);
            Thread.sleep(2000);
            lock.unlock();
            System.out.println(student + " has finished reading " + this);
        }
    }

    @Override
    public String toString() {
        return "Book " + id;
    }
}
