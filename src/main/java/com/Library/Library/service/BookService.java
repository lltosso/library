package com.Library.Library.service;

import com.Library.Library.model.Book;
import com.Library.Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   private  final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAll() {
        return  bookRepository.findAll();
    }
    public void addBook(Book newBook){
        bookRepository.save(newBook);

    }
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public  Optional<Book> findBook(int id) {
        return bookRepository.findById(id);
    }

   // public void updatedBook(int id) {
        //return bookRepository.

}


