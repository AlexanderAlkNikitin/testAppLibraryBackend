package com.anikitin.library.service;

import com.anikitin.library.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anikitin on 28.09.2016.
 */
@Service
public interface BookService {

    Integer saveOrUpdate(Book book);

    @Transactional
    Integer remove(Book book);

    Book getById(Integer id);

    List<Book> getAll();

}
