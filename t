package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
@Import(GlobalExceptionHandler.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getAllBooks_return200() throws Exception {

        Book b1 =
                new Book(1L, "Java", "Author A");

        Book b2 =
                new Book(2L, "Spring", "Author B");

        when(bookService.getAllBooks())
                .thenReturn(List.of(b1, b2));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getBookById_found() throws Exception {

        Book book =
                new Book(1L, "Java", "Author A");

        when(bookService.getBookById(1L))
                .thenReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title")
                        .value("Java"));
    }

    @Test
    void getBookById_notFound() throws Exception {

        when(bookService.getBookById(1L))
                .thenThrow(
                        new BookNotFoundException(
                                "Book not found"
                        )
                );

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isNotFound());
    }
}