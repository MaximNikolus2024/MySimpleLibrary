package org.mysimplelibrary.repository.authorRepository;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuthorRepository implements AuthorRepositoryInMemory {
    private List<Author> databaseAuthors;
    private Long authorIdCounter;

    public AuthorRepository() {
        this.databaseAuthors = new ArrayList<>();
        this.authorIdCounter = 0L;
    }

    @Override
    public Author addAuthor(Author author) {
        author.setId(++authorIdCounter);
        databaseAuthors.add(author);
        return author;
    }

    @Override
    public List<Author> findAllAuthors() {
        return databaseAuthors;
    }

    @Override
    public Optional<Author> findAuthorById(long id) {
        return databaseAuthors.stream()
                .filter(author -> author
                        .getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Author> findByName(String name) {
        return databaseAuthors.stream()
                .filter(author -> author
                        .getName()
                        .equals(name))
                .toList();
    }

    @Override
    public void deleteAuthorById(long id) {
        databaseAuthors.remove(findAuthorById(id));
    }

}

