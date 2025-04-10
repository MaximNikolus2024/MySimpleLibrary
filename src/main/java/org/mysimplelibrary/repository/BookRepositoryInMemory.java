package org.mysimplelibrary.repository;

import org.mysimplelibrary.entity.Book;

import java.util.List;

public interface BookRepositoryInMemory {
    List<Book> findAll();

    Book findById(Integer id);

    Book save(Book book);

    List<Book> findByTitle(String title);

    void deleteById(Integer id);
}
