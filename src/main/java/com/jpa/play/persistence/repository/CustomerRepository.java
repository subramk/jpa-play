package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
