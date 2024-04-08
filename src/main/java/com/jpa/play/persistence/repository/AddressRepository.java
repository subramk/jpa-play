package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
