package com.jpa.play.persistence.dao;

import com.jpa.play.persistence.domain.Author;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AuthorDao {

    Optional<Author> getAuthorByBookIsbn(String isbn);

}
