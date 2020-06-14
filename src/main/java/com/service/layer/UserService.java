package com.service.layer;

import java.util.List;

import com.jpa.play.persistence.model.User;


public interface UserService {

    public User findByName(String name);

    public List<User> findAll();

}
