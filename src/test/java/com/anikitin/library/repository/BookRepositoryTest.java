package com.anikitin.library.repository;

import com.anikitin.library.config.Config;
import com.anikitin.library.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by anikitin on 28.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class BookRepositoryTest {

    private Integer bookId;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    public void getById() throws Exception {
        saveOrUpdate();
        Book book = bookRepository.getById(bookId);
        assertNotNull(book);
    }

    @Test
    @Transactional
    public void remove() throws Exception {
        saveOrUpdate();
        Book book = bookRepository.getById(bookId);
        bookRepository.remove(book);
        assertNull(bookRepository.getById(bookId));
    }

    @Test
    @Transactional
    public void saveOrUpdate() throws Exception {
        Book book = new Book();
        book.setName("Book");
        book.setAuthor("Jhonny");
        book.setGenre("Horror");
        Integer id = bookRepository.saveOrUpdate(book).getId();
        bookId = id;
        assertNotNull(id);
    }

    @Test
    @Transactional
    public void update() throws Exception {
        saveOrUpdate();
        Book book = bookRepository.getById(bookId);
        book.setName("Updated");
        bookRepository.saveOrUpdate(book);
        assertEquals(book, bookRepository.getById(bookId));
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        int currentCount=bookRepository.getAll().size();
        if(currentCount==0){
            saveOrUpdate();
            saveOrUpdate();
            saveOrUpdate();
            assertEquals(3,bookRepository.getAll().size());
        }else {
            saveOrUpdate();
            saveOrUpdate();
            saveOrUpdate();
            assertEquals(currentCount+3,bookRepository.getAll().size());
        }
    }
}