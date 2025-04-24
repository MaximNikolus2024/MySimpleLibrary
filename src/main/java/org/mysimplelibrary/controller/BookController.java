package org.mysimplelibrary.controller;

import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookRequest;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.mysimplelibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(Book book) {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById (@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookResponse createBook(@RequestBody BookRequest request) {
        return bookService.addBook(request);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

}

