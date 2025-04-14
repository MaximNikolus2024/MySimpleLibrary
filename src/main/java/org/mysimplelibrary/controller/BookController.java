package org.mysimplelibrary.controller;

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
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/id")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping
    public void deleteBook(@PathVariable Book book) {
        bookService.delete(book);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(String title) {
        return bookService.findBookByName(title);
    }
}

