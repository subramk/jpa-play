package com.jpa.play.service.impl;

import com.jpa.play.persistence.domain.Book;
import com.jpa.play.persistence.repository.BookRepository;
import com.jpa.play.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository){
        this.bookRepository =  bookRepository;

    }

    @Override
    public Page<Book> getBooks(final Pageable pageable){
        return bookRepository.findAll(pageable);

    }

    @Override
    public Optional<Book> getBook(String isbn) {
        return bookRepository.findById(isbn);
    }


    public Optional<List<Book>> getBookByTitle(String title){
        return bookRepository.findByTitleContaining(title);

    }

}
