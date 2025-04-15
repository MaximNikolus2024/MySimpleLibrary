package org.mysimplelibrary.repository.authorRepository;

import org.mysimplelibrary.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> findAll();
    Optional<Author> findById(Integer id);
    List<Author> findByName(String name);
    Author save(Author author);
    void delete(Integer id);
}
