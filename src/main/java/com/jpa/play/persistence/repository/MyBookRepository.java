package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBook, Long> {
}
