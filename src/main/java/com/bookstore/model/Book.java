package com.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a Book entity mapped to the "books" table in the database.
 */
@Entity
@Table(name = "books")
@Getter  // Lombok annotation to generate getter methods
@Setter  // Lombok annotation to generate setter methods
@NoArgsConstructor  // Lombok annotation to generate a no-args constructor
@AllArgsConstructor  // Lombok annotation to generate an all-args constructor
public class Book {

    /**
     * Unique identifier for each book.
     * Auto-generated using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the book.
     */
    private String title;

    /**
     * Author of the book.
     */
    private String author;

    /**
     * Price of the book.
     * Uses BigDecimal for precision in financial calculations.
     */
    private BigDecimal price;

    /**
     * Date when the book was published.
     */
    private LocalDate publishedDate;
}
