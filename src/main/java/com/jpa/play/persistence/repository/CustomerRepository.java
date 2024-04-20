package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT cc from customer cc LEFT JOIN FETCH cc.addresses")
    List<Customer> retrieveAllCustomersWithAddress();


}
