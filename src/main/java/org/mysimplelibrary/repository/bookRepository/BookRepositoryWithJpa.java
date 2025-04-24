package org.mysimplelibrary.repository.bookRepository;

import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryWithJpa extends JpaRepository<Book, Long> {
    List<Book> findBookByAuthor(Author author);

    List<Book> findBookByTitle(String title);

    void deleteBookById(Long id);
}
