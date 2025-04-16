package org.mysimplelibrary.service;

import lombok.AllArgsConstructor;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.repository.authorRepository.AuthorRepositoryWithJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    public AuthorRepositoryWithJpa repository;
    public List<Author> findAll() {
        return repository.findAll();
    }
    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }
    public Author addAuthor(Author author) {
        return repository.save(author);
    }
    public Author updateAuthor(Author author) {
        return repository.save(author);
    }
    public List<Author> findByName(String name) {
        return repository.findByName(name);
    }
    public void deleteAuthor(Long id) {
        repository.deleteAuthorById(id);
    }
}
