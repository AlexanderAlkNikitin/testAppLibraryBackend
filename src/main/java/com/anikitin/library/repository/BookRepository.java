package com.anikitin.library.repository;

import com.anikitin.library.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anikitin on 28.09.2016.
 */
@Repository
public interface BookRepository {


    Book getById(Integer id);
    @Transactional
    void remove(Book book);

    @Transactional
    Book saveOrUpdate(Book book);

    List<Book> getAll();

}
