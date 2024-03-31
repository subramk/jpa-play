package com.jpa.play.ui.controller;


import com.jpa.play.persistence.domain.Book;
import com.jpa.play.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

@RestController("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(path="/list")
    public ResponseEntity<Page<Book>> listBooks(final Pageable pageable){
        // this is a comment
        String name = "kasi";

        return new ResponseEntity<Page<Book>>(bookService.getBooks(pageable), HttpStatus.OK);
    }


    @GetMapping(path="/isbn/{isbn}")
    public ResponseEntity<Book> listBooks(@PathVariable("isbn") final String isbn ,  final Pageable pageable){
        return bookService
                    .getBook(isbn)
                    .map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                    .orElse((new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @GetMapping(path="/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable("title") final String title ,  final Pageable pageable){
        List<Book> bookList = bookService
                .getBookByTitle(title)
                .stream()
                .flatMap(x -> x.stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return nonNull(bookList) && isNotEmpty(bookList) ? new ResponseEntity<>(bookList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
