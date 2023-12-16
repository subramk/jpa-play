package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long> {

	public Users findByName(String name);
	public List<Users> findAll();

}
