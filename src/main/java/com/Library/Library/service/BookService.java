package com.Library.Library.service;

import com.Library.Library.model.Book;
import com.Library.Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void addBook(Book newBook) {
        bookRepository.save(newBook);

    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBook(int id) {
        return bookRepository.findById(id);
    }

    public Book updatedBook(int id, Book updatedBook) {
            //Buscar producto por id
            Optional<Book> foundBook = bookRepository.findById(id);

            if(foundBook.isPresent()) {
                Book existingBook = foundBook.get();

                //Actualizar los campos
                existingBook.setTitle(updatedBook.getTitle());
                existingBook.setDescription(updatedBook.getDescription());
                existingBook.setAuthor(updatedBook.getAuthor());
                existingBook.setIsbn(updatedBook.getIsbn());
                existingBook.setGenre(updatedBook.getGenre());

                //Guarda el producto
                return bookRepository.save(existingBook);
        }

            //Enviar mensaje al usuario
            throw new RuntimeException("Book not found with id: " + id);
    }

    // FILTRAR POR TITULO
    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    // FILTRAR POR GENERO
    public Optional<Book> findBookByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    // FILTRAR POR AUTOR
    public Optional<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
}