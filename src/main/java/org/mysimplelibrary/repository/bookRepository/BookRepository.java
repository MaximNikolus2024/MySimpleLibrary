package org.mysimplelibrary.repository.bookRepository;

import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(Integer id);

    Book save(Book book);

    List<Book> findByTitle(String title);



    void delete(Integer id);


}
