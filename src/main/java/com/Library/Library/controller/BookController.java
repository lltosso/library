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

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book
             updatedBook) {
    try {
        //actualizar los campos del book en el caso de que encuentre
        Book book =  bookService.updatedBook(id, updatedBook);
        return new ResponseEntity<>(book, HttpStatus.OK);
    } catch (Exception e) {
        //en el caso que no se encuentre devuelve not found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }
    //FIND BY TITLE
    @RequestMapping("/book/title/{title}")
    public ResponseEntity<Book> findBookWithTitle(@PathVariable String title) {
        Optional<Book> foundBookWithTitle = bookService.findBookByTitle(title);

        if(foundBookWithTitle.isPresent()) {
            return new ResponseEntity<>(foundBookWithTitle.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //FIND BY GENRE
    @RequestMapping("/book/genre/{genre}")
    public ResponseEntity<Book> findBookWithGenre(@PathVariable String genre) {
        Optional<Book> foundBookWithGenre = bookService.findBookByGenre(genre);

        if(foundBookWithGenre.isPresent()) {
            return new ResponseEntity<>(foundBookWithGenre.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    //FIND BY AUTHOR
    @RequestMapping("/book/author/{author}")
    public ResponseEntity<Book> findBookWithAuthor(@PathVariable String author) {
        Optional<Book> foundBookWithAuthor = bookService.findBookByAuthor(author);

        if (foundBookWithAuthor.isPresent()) {
            return new ResponseEntity<>(foundBookWithAuthor.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
