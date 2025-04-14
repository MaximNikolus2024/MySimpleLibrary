package org.mysimplelibrary.controller;

import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors() {
       return authorService.findAllAuthors();
    }
    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Integer id) {
        return authorService.findAuthorById(id);
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
        author.setId(id);
        return authorService.addAuthor(author);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthorById(id);
    }


}
