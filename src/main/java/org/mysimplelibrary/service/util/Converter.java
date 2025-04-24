package org.mysimplelibrary.service.util;

import org.mysimplelibrary.dto.authorDto.AuthorRequest;
import org.mysimplelibrary.dto.authorDto.AuthorResponse;
import org.mysimplelibrary.dto.bookDto.BookRequest;
import org.mysimplelibrary.dto.bookDto.BookResponse;
import org.mysimplelibrary.entity.Author;
import org.mysimplelibrary.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public Book fromDto(BookRequest bookRequest) {
        Book book = new Book();
        book.setId(bookRequest.getId());
        book.setTitle(bookRequest.getTitle());
        book.setBookDescription(bookRequest.getDescription());
        return book;
    }

    public BookResponse toDto(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setId(book.getId());
        bookResponse.setBookDescription(book.getBookDescription());


        Author author = book.getAuthor();
        AuthorResponse authorResponse = dtoFromAuthor(author);
        bookResponse.setAuthorResponse(authorResponse);
        return bookResponse;
    }

    public AuthorResponse dtoFromAuthor(Author author) {
        AuthorResponse authorResponse = new AuthorResponse(
                author.getName(),
                author.getId(),


                author.getEmail()
        );
        return authorResponse;

    }

    public Author authorFromDto(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setId(authorRequest.getAuthorId());
        author.setName(authorRequest.getAuthorName());
        author.setEmail(authorRequest.getAuthorEmail());
        return author;
    }
}
