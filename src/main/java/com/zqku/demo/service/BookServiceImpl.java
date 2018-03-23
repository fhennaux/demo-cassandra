package com.zqku.demo.service;

import com.zqku.demo.converter.BookToBookViewConverter;
import com.zqku.demo.converter.BookViewToBookConverter;
import com.zqku.demo.model.Book;
import com.zqku.demo.repository.BookRepository;
import com.zqku.demo.view.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private BookViewToBookConverter bookViewToBookConverter;

    private BookToBookViewConverter bookToBookViewConverter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepositor, BookViewToBookConverter bookViewToBookConverter,BookToBookViewConverter bookToBookViewConverter) {
        this.bookRepository = bookRepositor;
        this.bookViewToBookConverter = bookViewToBookConverter;
        this.bookToBookViewConverter = bookToBookViewConverter;
    }

    @Override
    public List<BookView> listAll() {

        List<Book> bookList = bookRepository.findAll();
        List<BookView> bookViewList = bookList.stream()
                .map(book -> bookToBookViewConverter.convert(book))
                .collect(Collectors.toList());
        return bookViewList;
    }

    @Override
    public BookView getById(UUID id) {

        Book book = bookRepository.findById(id).orElse(null);
        return bookToBookViewConverter.convert(book);
    }

    @Override
    public void saveOrUpdate(Book book) {

        bookRepository.save(book);
    }

    @Override
    public void delete(UUID id) {

        bookRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdateBookView(BookView bookView) {

        saveOrUpdate(bookViewToBookConverter.convert(bookView));
    }
}
