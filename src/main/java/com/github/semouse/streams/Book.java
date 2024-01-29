package com.github.semouse.streams;

public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private final Type type;

    public Book(String title, String author, int pages, Type type) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }
}
