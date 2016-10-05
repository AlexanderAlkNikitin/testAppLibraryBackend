package com.anikitin.library.repository;

import com.anikitin.library.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by anikitin on 28.09.2016.
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book getById(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void remove(Book book) {
        entityManager.remove(entityManager.getReference(Book.class,book.getId()));
    }

    @Override
    public Book saveOrUpdate(Book book) {
        if (book.getId() != null) {
            entityManager.merge(book);
        } else {
            entityManager.persist(book);
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findAll", Book.class);
        return typedQuery.getResultList();
    }
}
