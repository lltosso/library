package com.Library.Library.controller;

import com.Library.Library.model.Book;
import com.Library.Library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

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

    @DeleteMapping("/book/{id}")
    public void deleteBookByid(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable int id){
        Optional<Book> foundBook = bookService.findBook(id);

        if(foundBook.isPresent()) {
            return new ResponseEntity<>(foundBook.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
