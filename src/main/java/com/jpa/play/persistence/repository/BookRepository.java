package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book,String>, PagingAndSortingRepository<Book,String> , JpaRepository<Book,String> {

    public Optional<List<Book>> findByTitleContaining(String bookTitle);

    //public Optional<Book> findByAuthor_NameIsLike(String authorName);




}
