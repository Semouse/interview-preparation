package com.examples.memes.students;

import java.util.Random;

import static com.examples.memes.students.Constants.NUMBER_OF_BOOKS;

public class Student implements Runnable {
    private final int id;
    private final Book[] books;
    private final Random random;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
    }


    @Override
    public void run() {
        while (true) {
            int bookId = random.nextInt(NUMBER_OF_BOOKS);
            try {
                books[bookId].read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student #" + id;
    }
}
