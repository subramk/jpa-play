package com.jpa.play.persistence.dao;

import com.jpa.play.persistence.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookDao {

    List<Book> listBooks();

}


