package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing book operations.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Adds a new book to the database.
     *
     * @param book The book to be added.
     * @return The saved book.
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Retrieves all books from the database.
     *
     * @return A list of all books.
     */
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll(); // Casting Iterable to List
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id The ID of the book to retrieve.
     * @return An Optional containing the book if found, otherwise empty.
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Updates an existing book by ID.
     *
     * @param id The ID of the book to update.
     * @param updatedBook The updated book details.
     * @return The updated book.
     * @throws RuntimeException if the book is not found.
     */
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            // Updating book fields
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            book.setPublishedDate(updatedBook.getPublishedDate());

            // Saving the updated book
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id The ID of the book to delete.
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
