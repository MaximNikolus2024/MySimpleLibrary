package org.mysimplelibrary.repository.authorRepository;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private List<Author> databaseAuthors;
    private Integer authorIdCounter;

    public AuthorRepositoryImpl() {
        this.databaseAuthors = new ArrayList<>();
        this.authorIdCounter = 0;
    }

    @Override
    public List<Author> findAll() {
        return databaseAuthors;
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return databaseAuthors.stream()
                .filter(author -> author
                        .getId()
                        .equals(id))
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
    public Author save(Author author) {
        author.setId(++authorIdCounter);
        databaseAuthors.add(author);
        return author;
    }

    @Override
    public void delete(Integer id) {
        databaseAuthors.remove(id);
    }

}
