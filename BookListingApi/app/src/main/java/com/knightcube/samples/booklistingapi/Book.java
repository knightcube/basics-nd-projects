package com.knightcube.samples.booklistingapi;

public class Book {
    String title;
    String authors;
    String description;

    public Book(String title, String authors, String description) {
        this.title = title;
        this.authors = authors;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }
}
