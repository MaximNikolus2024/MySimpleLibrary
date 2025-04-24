package org.mysimplelibrary.service;

import lombok.AllArgsConstructor;
import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookRequest;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.mysimplelibrary.repository.bookRepository.BookRepositoryWithJpa;
import org.mysimplelibrary.service.exception.NotFoundException;
import org.mysimplelibrary.service.util.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepositoryWithJpa repository;
    private AuthorService authorService;
    private Converter converter;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }else {
            throw new NotFoundException("Book with id " + id + " not found");
        }

    }

    public BookResponse addBook(BookRequest request) {
       Optional<Author> optionalAuthor= authorService.findByEmail(request.getAuthorEmail());
       Book newBook =converter.fromDto(request) ;
       newBook.setAuthor(optionalAuthor.get());
       Book savedBook = repository.save(newBook);
       BookResponse response = converter.toDto(savedBook);
        return response;
    }

    public List<BookResponse> findByAuthorEmail(String authorEmail) {
       Optional<Author> optionalAuthor = authorService.findByEmail(authorEmail);
       Author author = optionalAuthor.get();
       List<BookResponse> bookResponses = repository.findBookByAuthor(author).stream()
               .map(book -> converter.toDto(book)).toList();
       return bookResponses;
    }

    public Book updateBook(Book book) {
        return repository.save(book);
    }

    public List<Book> findByTitle(String title) {
        return repository.findBookByTitle(title);
    }

    public void deleteBookById(Long id) {

    }


}


