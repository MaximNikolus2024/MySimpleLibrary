package org.mysimplelibrary.repository.bookRepository;

import org.mysimplelibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryInMemory {
    List<Book> findAll();

   Optional<Book>  findById(Long id);

    Book save(Book book);

    List<Book> findByTitle(String title);

    void deleteById(Long id);
}
