package org.mysimplelibrary.service;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.repository.authorRepository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }
    public Author addAuthor(Author author) {
        return repository.save(author);
    }
public Optional<Author> findAuthorById(Integer authorId) {
        return repository.findById(authorId);
}
public List<Author> findAllAuthors() {
        return repository.findAll();
}
public List<Author> findAuthorsByName(String name) {
        return repository.findByName(name);
}
public void deleteAuthorById(Integer id) {
      repository.findById(id)
              .ifPresent(author -> repository
                      .findAll()
                      .remove(author));
}
}
