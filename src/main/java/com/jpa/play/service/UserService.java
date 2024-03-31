package com.jpa.play.service;

import com.jpa.play.persistence.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    public Users findByName(String name);

    public List<Users> findAll();
}
