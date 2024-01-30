package com.github.semouse.oop.books;

import java.util.Arrays;

public class BookService {

    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        if(books == null || author == null){
            return new Book[0];
        }
        return Arrays.stream(books).filter(book -> book.hasAuthor(author)).toArray(Book[]::new);
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        if(books == null || publisher == null){
            return new Book[0];
        }
        return Arrays.stream(books).filter(book -> book.getPublisher().equals(publisher))
            .toArray(Book[]::new);
    }

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        if(books == null){
            return new Book[0];
        }
        return Arrays.stream(books).filter(book -> book.getPublishingYear() >= yearFromInclusively)
            .toArray(Book[]::new);
    }
}
