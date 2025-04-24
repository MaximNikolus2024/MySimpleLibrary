package org.mysimplelibrary.service;

import lombok.AllArgsConstructor;
import org.mysimplelibrary.dto.authorDto.AuthorRequest;
import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.repository.authorRepository.AuthorRepositoryWithJpa;
import org.mysimplelibrary.service.exception.AlreadyExistException;
import org.mysimplelibrary.service.exception.NotFoundException;
import org.mysimplelibrary.service.util.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    public AuthorRepositoryWithJpa repository;
public Converter converter;

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author findById(Long id) {
        Optional<Author> author = repository.findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new NotFoundException("Manager with ID = " + id + " not found");
        }
    }

    public AuthorResponse addAuthor(AuthorRequest request) {
        if (isExistAuthor(request.getAuthorEmail())){
            throw new AlreadyExistException("Author with email " + request.getAuthorEmail() + " already exist");
        }
        Author newAuthor = converter.authorFromDto(request);
        Author savedAuthor = repository.save(newAuthor);

        AuthorResponse response = converter.dtoFromAuthor(savedAuthor);
        return response;
    }
    private boolean isExistAuthor(String email) {
        Optional<Author> existManager = repository.findByAuthorByEmail(email);
        return existManager.isPresent();

    }

    public Author updateAuthor(Author author) {
        return repository.save(author);
    }

    public List<Author> findByName(String name) {
        return repository.findByName(name);
    }
    public AuthorResponse findAuthorByEmail(String email) {
        Optional<Author> optionalAuthor = repository.findByAuthorByEmail(email);
        if (optionalAuthor.isPresent()) {
            AuthorResponse authorResponse = converter.dtoFromAuthor(optionalAuthor.get());
            return authorResponse;
        }else {
            throw new NotFoundException("Manager with email = " + email + " not found");
        }
    }
    public Optional<Author> findByEmail(String email) {
        return repository.findByAuthorByEmail(email);
    }

    public void deleteAuthor(Long id) {
        repository.deleteAuthorById(id);
    }
}
