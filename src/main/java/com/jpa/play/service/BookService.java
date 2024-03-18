package com.jpa.play.service;

import com.jpa.play.persistence.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    Page<Book> getBooks(Pageable pageable);

    Optional<Book> getBook(String isbn);

    Optional<List<Book>> getBookByTitle(String title);



}
