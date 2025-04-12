package org.mysimplelibrary.repository.authorRepository;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryInMemory {
    Author addAuthor(Author author);
    List<Author> findAllAuthors();
    Optional<Author> findAuthorById(long id);
    List<Author> findByName(String name);
    void deleteAuthorById(long id);

}
