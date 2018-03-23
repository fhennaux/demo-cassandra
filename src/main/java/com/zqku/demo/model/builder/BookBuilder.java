package com.zqku.demo.model.builder;

import com.zqku.demo.model.Book;

import java.util.UUID;

public final class BookBuilder {
    private UUID id;
    private String title;
    private String publisher;

    private BookBuilder() {
    }

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublisher(publisher);
        return book;
    }
}
