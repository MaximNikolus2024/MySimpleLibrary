package org.mysimplelibrary.repository.bookRepository;

import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepository implements BookRepositoryInMemory {
    private List<Book> databaseBooks = new ArrayList<>();
    private Integer idBookCounter = 0;

    @Override
    public List<Book> findAll() {
        return databaseBooks;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return databaseBooks.stream()
                .filter(book -> book
                        .getId()
                        .equals(id))
                .findFirst();
    }



    @Override
    public Book save(Book book) {
        book.setId(++idBookCounter);
        databaseBooks.add(book);
        return book;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return databaseBooks.stream()
                .filter(book -> book.getTitle()
                        .equals(title))
                .toList();

    }

    @Override
    public void deleteById(Long id) {
        databaseBooks.removeIf(book -> book.getId().equals(id));
    }



}
