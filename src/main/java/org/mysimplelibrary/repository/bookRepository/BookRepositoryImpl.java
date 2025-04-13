package org.mysimplelibrary.repository.bookRepository;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> databaseBooks;
    private Integer bookIdCounter;

    public BookRepositoryImpl() {
        databaseBooks = new ArrayList<>();
        bookIdCounter = 0;
    }

    @Override
    public List<Book> findAll() {
        return databaseBooks;
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
        book.setId(++bookIdCounter);
        databaseBooks.add(book);
        return book;
    }

    @Override
    public List<Book> findByTitle(String title) {
        return databaseBooks.stream()
                .filter(book -> book
                        .getTitle()
                        .equals(title))
                .toList();
    }

    @Override
    public void delete(Book book) {
        databaseBooks.remove(book);
    }


    @Override
    public List<Book> findByAuthor(Author author) {
        return databaseBooks.stream()
                .filter(book -> book
                        .getAuthor()
                        .equals(author))
                .toList();
    }
}
