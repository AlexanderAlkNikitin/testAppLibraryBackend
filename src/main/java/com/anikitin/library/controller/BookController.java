package com.anikitin.library.controller;

import com.anikitin.library.model.Book;
import com.anikitin.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anikitin on 28.09.2016.
 */
@RestController
@RequestMapping("books")
public class BookController {
    private static final Logger logger = LoggerFactory
            .getLogger(BookController.class);
    @Autowired
    private BookService bookService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Book save(@RequestBody Book book){
        logger.info("book receive");
        logger.info("{}",book);
        bookService.saveOrUpdate(book);
        logger.info("{}",book);
        logger.info("book saved");
        return book;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Book getById(@PathVariable("id") Integer id){
        logger.info("{}",id);
        Book book= bookService.getById(id);
        logger.info("{}",book);
        return book;
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Integer delete(@RequestBody Book book){
        logger.info("{}",book);
        Integer deletedId=bookService.remove(book);
        logger.info("{}",deletedId);
        return deletedId;
    }

}
