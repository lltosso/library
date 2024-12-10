package com.Library.Library.controller;

import com.Library.Library.model.Book;
import com.Library.Library.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping("/book")
    public List<Book> getAllBook() {
        return bookService.getAll();
    }
    @PostMapping("/book")
    public void createBook(@RequestBody Book newBook) {
        bookService.addBook(newBook);
    }
}
