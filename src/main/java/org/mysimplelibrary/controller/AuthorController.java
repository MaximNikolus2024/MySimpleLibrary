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
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return authorService.updateAuthor(author);
    }

    @GetMapping("/search")

    public List<Author> searchAuthor(@RequestParam String name) {
        return authorService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
