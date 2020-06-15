package com.jpa.play.service;

import java.util.List;

import com.jpa.play.persistence.model.Users;


public interface UserService {

    public Users findByName(String name);

    public List<Users> findAll();

}
