package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {

        log.debug("Get all books request");

        List<Book> books = bookRepository.findAll();

        log.info("Found {} books", books.size());

        return books;
    }

    public Book getBookById(Long id) {

        log.debug("Get book by id: {}", id);

        return bookRepository.findById(id)
                .map(book -> {
                    log.info("Book found with id {}", id);
                    return book;
                })
                .orElseThrow(() -> {
                    log.error("Book not found with id {}", id);
                    return new BookNotFoundException(
                            "Book not found with id " + id
                    );
                });
    }

    public Book createBook(Book book) {

        log.debug("Create book request: {}", book);

        Book savedBook = bookRepository.save(book);

        log.info("Book created successfully with id {}",
                savedBook.getId());

        return savedBook;
    }
}