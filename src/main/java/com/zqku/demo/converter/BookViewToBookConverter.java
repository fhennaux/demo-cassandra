package com.zqku.demo.converter;

import com.zqku.demo.model.Book;
import com.zqku.demo.model.builder.BookBuilder;
import com.zqku.demo.view.BookView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BookViewToBookConverter implements Converter<BookView, Book> {


    @Nullable
    @Override
    public Book convert(BookView bookView) {

        return BookBuilder.aBook()
                .withId(bookView.getId())
                .withPublisher(bookView.getPublisher())
                .withTitle(bookView.getTitle())
                .build();
    }
}
