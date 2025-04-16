package org.mysimplelibrary.service;

import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.mysimplelibrary.repository.bookRepository.BookRepositoryWithJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepositoryWithJpa repository;
    public List<Book> findAll() {
        return repository.findAll();
    }
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }
    public Book addBook(Book book) {
        return repository.save(book);
    }
    public List<Book> findByAuthor(AuthorResponse response) {
        return repository.findBookByAuthor(response);
    }
    public Book updateBook(Book book) {
        return repository.save(book);
    }
    public List<Book> findByTitle(String title) {
        return repository.findBookByTitle(title);
    }
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

}


