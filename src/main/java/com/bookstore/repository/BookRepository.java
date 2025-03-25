package com.bookstore.repository;

import com.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Book entities.
 * Extends CrudRepository to provide basic CRUD operations.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // CrudRepository provides basic CRUD operations like save(), findById(), findAll(), deleteById(), etc.
}
