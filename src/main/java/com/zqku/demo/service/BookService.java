package com.zqku.demo.service;

import com.zqku.demo.model.Book;
import com.zqku.demo.view.BookView;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<BookView> listAll();

    BookView getById(UUID id);

    void saveOrUpdate(Book book);

    void delete(UUID id);

    void saveOrUpdateBookView(BookView BookForm);
}
