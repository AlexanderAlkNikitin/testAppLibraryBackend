package com.anikitin.library.service;

import com.anikitin.library.model.Book;
import com.anikitin.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anikitin on 28.09.2016.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Integer saveOrUpdate(Book book) {
        bookRepository.saveOrUpdate(book);
        return book.getId();
    }

    @Override
    public Integer remove(Book book) {
        bookRepository.remove(book);
        return book.getId();
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }
}
