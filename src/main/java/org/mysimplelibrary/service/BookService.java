package org.mysimplelibrary.service;

import org.mysimplelibrary.entity.Book;
import org.mysimplelibrary.repository.bookRepository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }
    public List<Book> findAll() {
        return repository.findAll();
    }
    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }
    public Book save(Book book) {
        return repository.save(book);
    }
    public List<Book> findBookByName(String title) {
        return repository.findByTitle(title);
    }
  public void delete(Book book) {
        repository.delete(book);
  }
}
