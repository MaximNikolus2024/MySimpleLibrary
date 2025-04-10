package org.mysimplelibrary.repository;

import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookRepository implements BookRepositoryInMemory {
    private List<Book> databaseBooks = new ArrayList<>();
    private Integer idBookCounter = 0;

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return databaseBooks.stream()
                .filter(book -> book
                        .getId()
                        .equals(id))
                .findFirst();
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return databaseBooks.stream()
                .filter(book -> book.getTitle()
                        .equals(title))
                .toList();

    }


    @Override
    public void deleteById(Integer id) {
        databaseBooks.removeIf(book -> book.getId().equals(id));
    }
}
