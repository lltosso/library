package com.Library.Library.service;

import com.Library.Library.model.Book;
import com.Library.Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

   private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAll() {
        return  bookRepository.findAll();
    }
    public Book addBook(Book newBook){
        return bookRepository.save(newBook);
    }
}


