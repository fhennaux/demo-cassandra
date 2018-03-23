package com.zqku.demo.converter;

import com.zqku.demo.model.Book;
import com.zqku.demo.view.BookView;
import com.zqku.demo.view.builder.BookViewBuilder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BookToBookViewConverter implements Converter<Book,BookView> {


    @Nullable
    @Override
    public BookView convert(Book book) {

        return BookViewBuilder.aBookView()
                .withId(book.getId())
                .withPublisher(book.getPublisher())
                .withTitle(book.getTitle()).build();
    }
}
