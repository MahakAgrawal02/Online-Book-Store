package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing book-related operations.
 * Provides endpoints for adding, retrieving, updating, and deleting books.
 */
@RestController
@RequestMapping("/api/books")  // Base URL for all book-related operations
public class BookController {

    // Injecting BookService to handle business logic
    @Autowired
    private BookService bookService;

    /**
     * Endpoint to add a new book.
     *
     * @param book The book object to be added (sent in request body)
     * @return ResponseEntity containing the added book
     */
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    /**
     * Endpoint to retrieve all books.
     *
     * @return ResponseEntity containing a list of all books
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    /**
     * Endpoint to retrieve a specific book by its ID.
     *
     * @param id The ID of the book to be retrieved
     * @return ResponseEntity containing the book if found, or a 404 status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to update an existing book.
     *
     * @param id   The ID of the book to be updated
     * @param book The updated book details (sent in request body)
     * @return ResponseEntity containing the updated book
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    /**
     * Endpoint to delete a book by its ID.
     *
     * @param id The ID of the book to be deleted
     * @return ResponseEntity with no content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
