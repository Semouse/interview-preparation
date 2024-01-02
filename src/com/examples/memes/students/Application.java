package com.examples.memes.students;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static com.examples.memes.students.Constants.NUMBER_OF_BOOKS;
import static com.examples.memes.students.Constants.NUMBER_OF_STUDENTS;

public class Application {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_STUDENTS);
        try {
            Book[] books = new Book[NUMBER_OF_BOOKS];
            Student[] students = new Student[NUMBER_OF_STUDENTS];

            IntStream.range(0, NUMBER_OF_BOOKS).forEach(i -> books[i] = new Book(i + 1));
            IntStream.range(0, NUMBER_OF_STUDENTS).forEach(i -> {
                students[i] = new Student(i + 1, books);
                service.execute(students[i]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
