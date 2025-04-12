package org.mysimplelibrary.service;


import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.repository.authorRepository.AuthorRepository;
import org.mysimplelibrary.repository.authorRepository.AuthorRepositoryInMemory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService {
    private AuthorRepositoryInMemory authorRepository;

    public AuthorService(AuthorRepositoryInMemory authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author addAuthor(Author author) {
        return authorRepository.addAuthor(author);
    }
    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findAuthorById(id);
    }
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthors();
    }
    public void deleteAuthor(Integer id) {
       authorRepository.findAuthorById(id).ifPresent(author -> {
           authorRepository.findAllAuthors().remove(author);
       });
    }

}
