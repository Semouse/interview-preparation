package com.github.semouse.oop.books;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Book {

    private final int id;
    private final String name;
    private final Author[] authors;
    private final Publisher publisher;
    private final int publishingYear;
    private final int amountOfPages;
    private final BigDecimal price;
    private final CoverType coverType;

    public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear,
        int amountOfPages, BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }

    public boolean hasAuthor(Author criteria) {
        for (Author author : authors) {
            if (author.equals(criteria)) {
                return true;
            }
        }

        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id == book.id && publishingYear == book.publishingYear
            && amountOfPages == book.amountOfPages && Objects.equals(name, book.name)
            && Arrays.equals(authors, book.authors) && Objects.equals(publisher, book.publisher)
            && Objects.equals(price, book.price) && Objects.equals(coverType, book.coverType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, publisher, publishingYear, amountOfPages, price,
            coverType);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", authors=" + Arrays.toString(authors) +
            ", publisher=" + publisher +
            ", publishingYear=" + publishingYear +
            ", amountOfPages=" + amountOfPages +
            ", price=" + price +
            ", coverType=" + coverType +
            '}';
    }
}
