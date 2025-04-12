package org.mysimplelibrary.controller;


import org.mysimplelibrary.dto.authorDto.AuthorRequestDto;
import org.mysimplelibrary.dto.authorDto.AuthorResponseDto;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;
@Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
@PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        Author author = new Author(authorRequestDto.getAuthorName(), null);
        authorService.addAuthor(author);
        AuthorResponseDto response = new AuthorResponseDto(author.getName(), author.getId());
        return ResponseEntity.ok(response);
    }
@GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable Integer id) {
        return authorService.getAuthorById(id)
                .map(author -> new AuthorResponseDto(author.getName(), author.getId()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
@GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        List<AuthorResponseDto> authors = authorService.getAllAuthors().stream()
                .map(author -> new AuthorResponseDto(author.getName(), author.getId()))
                .toList();
        return ResponseEntity.ok(authors);
    }
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
    author.setId(id);
    return authorService.addAuthor(author);
    }
@DeleteMapping("/{id}")
   public void deleteAuthorById(@PathVariable Long id) {
    authorService.deleteAuthor(id);
   }
   @GetMapping("/search")
   public List<Author> searchAuthorByName(@RequestParam String authorName) {
    return authorService.findAuthorsByName(authorName);
   }
}
