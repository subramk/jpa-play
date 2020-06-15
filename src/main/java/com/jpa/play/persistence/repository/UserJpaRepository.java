package com.jpa.play.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.play.persistence.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

	public Users findByName(String name);

	public List<Users> findAll();

}
