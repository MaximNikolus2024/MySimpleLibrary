package org.mysimplelibrary.service;


import org.mysimplelibrary.entity.Book;
import org.mysimplelibrary.repository.authorRepository.AuthorRepositoryInMemory;
import org.mysimplelibrary.repository.bookRepository.BookRepositoryInMemory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
private AuthorRepositoryInMemory authorRepository;
private BookRepositoryInMemory bookRepository;

    public BookService(AuthorRepositoryInMemory authorRepository, BookRepositoryInMemory bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
