package com.examples.streams;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on The Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Hermann Broch", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        printBookWithMaximumPages(books);
        printTotalPagesCount(books);
        printTwoWordTitleBooks(books);
        printTwoLongestBooks(books);
        printIfAllBookHasAtLeastNpages(books, 100);
        printIfNoBooksHasAtLeastNpages(books, 100);
        printAnyTypeBook(books, Type.HISTORY);
    }

    //In sequential approach findFirst same to findAny
    private static void printAnyTypeBook(List<Book> books, Type type) {
        System.out.println("Book with " + type + " type: ");
        books.stream().filter(book -> book.getType() == type).findFirst().ifPresent(System.out::println);
    }

    private static void printIfNoBooksHasAtLeastNpages(List<Book> books, int pages) {
        System.out.println("Is no books has at least " + pages + " pages: ");
        System.out.println(books.stream().noneMatch(book -> book.getPages() >= pages));
    }

    private static void printIfAllBookHasAtLeastNpages(List<Book> books, int pages) {
        System.out.println("Is all books has at least " + pages + " pages: ");
        System.out.println(books.stream().allMatch(book -> book.getPages() >= pages));
    }

    private static void printTwoWordTitleBooks(List<Book> books) {
        System.out.println("Two word  all the book where the title is made up of exactly 2 words: ");
        books.stream()
                .filter(book -> book.getTitle().split("\\s+").length == 2)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printTwoLongestBooks(List<Book> books) {
        System.out.println("Two longest books titles with more than 500 pages");
        books.stream().filter(p -> p.getPages() > 500).map(Book::getTitle).limit(2).forEach(System.out::println);
        System.out.println();
    }

    private static void printTotalPagesCount(List<Book> books) {
        System.out.println("Total pages number of all books:");
        int totalPages = books.stream().mapToInt(Book::getPages).sum();
        System.out.println(totalPages);
    }

    private static void printBookWithMaximumPages(List<Book> books) {
        System.out.println("Maximum pages book: ");
        books.stream().reduce((b1, b2) -> b1.getPages() > b2.getPages() ? b1 : b2).ifPresent(System.out::println);
    }
}
