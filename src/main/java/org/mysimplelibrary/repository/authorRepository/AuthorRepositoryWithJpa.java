package org.mysimplelibrary.repository.authorRepository;

import org.mysimplelibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryWithJpa extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);

    void deleteAuthorById(Long id);

    Optional<Author> findByAuthorByEmail(String email);
}
