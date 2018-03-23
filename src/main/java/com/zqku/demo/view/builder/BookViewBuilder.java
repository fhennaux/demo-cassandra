package com.zqku.demo.view.builder;

import com.zqku.demo.view.BookView;

import java.util.UUID;

public final class BookViewBuilder {
    private UUID id;
    private String title;
    private String publisher;

    private BookViewBuilder() {
    }

    public static BookViewBuilder aBookView() {
        return new BookViewBuilder();
    }

    public BookViewBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public BookViewBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookViewBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookView build() {
        BookView bookView = new BookView();
        bookView.setId(id);
        bookView.setTitle(title);
        bookView.setPublisher(publisher);
        return bookView;
    }
}
