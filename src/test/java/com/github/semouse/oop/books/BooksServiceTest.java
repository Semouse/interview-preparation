package com.github.semouse.oop.books;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BooksServiceTest {

    private static final int THRESHOLD_YEAR = 1992;
    private static final int PUBLISH_YEAR_MORE_THAN_THRESHOLD = 1993;
    private BookService testInstance;
    private Book[] testBooks;

    @BeforeEach
    void setUp() {
        testInstance = new BookService();
        testBooks = new Book[]{
            new Book(1, "Book_1", new Author[]{new Author(1, "Jon", "Johnson")},
                new Publisher(1, "Publisher_1"), 1990, 231,
                BigDecimal.valueOf(24.99), CoverType.PAPERBACK),
            new Book(2, "Book_2",
                new Author[]{new Author(1, "Jon", "Johnson"),
                    new Author(2, "William", "Wilson")},
                new Publisher(2, "Publisher_2"), 2000, 120,
                BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
            new Book(3, "Book_3",
                new Author[]{new Author(3, "Walter", "Peterson")},
                new Publisher(1, "Publisher_1"), 1997, 350,
                BigDecimal.valueOf(34.99), CoverType.HARDCOVER),
            new Book(4, "Book_4", new Author[]{new Author(4, "Craig", "Gregory")},
                new Publisher(3, "Publisher_3"), 1992, 185,
                BigDecimal.valueOf(19.99), CoverType.PAPERBACK)};
    }


    @Test
    void shouldReturnEmptyBookArrayWhenFilterByAuthorIfAuthorIsNull() {
        Book[] filteredBooks = testInstance.filterBooksByAuthor(null, testBooks);
        assertEquals(0, filteredBooks.length);
    }

    @Test
    void shouldReturnEmptyBookArrayWhenFilterByAuthorIfBooksIsNull() {
        Book[] filteredBooks = testInstance
            .filterBooksByAuthor(new Author(4, "Craig", "Gregory"), null);
        assertEquals(0, filteredBooks.length);
    }

    @Test
    void shouldFilterBooksByAuthor() {
        Book[] filteredBooks = testInstance
            .filterBooksByAuthor(new Author(1, "Jon", "Johnson"), testBooks);

        Book[] expectedArray = new Book[]{
            new Book(1, "Book_1", new Author[]{new Author(1, "Jon", "Johnson")},
                new Publisher(1, "Publisher_1"), 1990, 231,
                BigDecimal.valueOf(24.99), CoverType.PAPERBACK),
            new Book(2, "Book_2",
                new Author[]{new Author(1, "Jon", "Johnson"),
                    new Author(2, "William", "Wilson")},
                new Publisher(2, "Publisher_2"), 2000, 120,
                BigDecimal.valueOf(14.99), CoverType.PAPERBACK)};
        assertArrayEquals(expectedArray, filteredBooks);
    }

    @Test
    void shouldReturnEmptyBookArrayWhenFilterByPublisherIfPublisherIsNull() {
        Book[] filteredBooks = testInstance.filterBooksByPublisher(null, testBooks);
        assertEquals(0, filteredBooks.length);
    }

    @Test
    void shouldReturnEmptyBookArrayWhenFilterByPublisherIfBooksIsNull() {
        Book[] filteredBooks = testInstance
            .filterBooksByPublisher(new Publisher(2, "Publisher_2"), null);
        assertEquals(0, filteredBooks.length);
    }

    @Test
    void shouldFilterBooksByPublisher() {
        Book[] filteredBooks = testInstance
            .filterBooksByPublisher(new Publisher(2, "Publisher_2"), testBooks);

        Book[] expectedArray = new Book[]{new Book(2, "Book_2",
            new Author[]{new Author(1, "Jon", "Johnson"),
                new Author(2, "William", "Wilson")},
            new Publisher(2, "Publisher_2"), 2000, 120, BigDecimal.valueOf(14.99),
            CoverType.PAPERBACK)};
        assertArrayEquals(expectedArray, filteredBooks);
    }

    @Test
    void shouldReturnEmptyBookArrayWhenFilterByPublishYearIfBooksIsNull() {
        Book[] filteredBooks = testInstance.filterBooksAfterSpecifiedYear(THRESHOLD_YEAR,
            null);
        assertEquals(0, filteredBooks.length);
    }

    @Test
    void shouldFilterBooksByAfterSpecifiedYearInclusively() {
        Book[] filteredBooks = testInstance.filterBooksAfterSpecifiedYear(THRESHOLD_YEAR,
            testBooks);

        Book[] expectedArray = new Book[]{
            new Book(2, "Book_2",
                new Author[]{new Author(1, "Jon", "Johnson"),
                    new Author(2, "William", "Wilson")},
                new Publisher(2, "Publisher_2"), 2000, 120,
                BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
            new Book(3, "Book_3",
                new Author[]{new Author(3, "Walter", "Peterson")},
                new Publisher(1, "Publisher_1"), 1997, 350,
                BigDecimal.valueOf(34.99), CoverType.HARDCOVER),
            new Book(4, "Book_4", new Author[]{new Author(4, "Craig", "Gregory")},
                new Publisher(3, "Publisher_3"), 1992, 185,
                BigDecimal.valueOf(19.99), CoverType.PAPERBACK)};
        assertArrayEquals(expectedArray, filteredBooks);
    }

    @Test
    void shouldFilterBooksByAfterSpecifiedYear() {
        Book[] filteredBooks = testInstance.filterBooksAfterSpecifiedYear(
            PUBLISH_YEAR_MORE_THAN_THRESHOLD,
            testBooks);

        Book[] expectedArray = new Book[]{
            new Book(2, "Book_2",
                new Author[]{new Author(1, "Jon", "Johnson"),
                    new Author(2, "William", "Wilson")},
                new Publisher(2, "Publisher_2"), 2000, 120,
                BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
            new Book(3, "Book_3",
                new Author[]{new Author(3, "Walter", "Peterson")},
                new Publisher(1, "Publisher_1"), 1997, 350,
                BigDecimal.valueOf(34.99), CoverType.HARDCOVER)};
        assertArrayEquals(expectedArray, filteredBooks);
    }
}
