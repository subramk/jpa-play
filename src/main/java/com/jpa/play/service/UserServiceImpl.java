package com.jpa.play.service;


import java.util.List;

import com.jpa.play.persistence.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.play.persistence.model.Users;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public Users findByName(String name){
        return userJpaRepository.findByName(name);

    }

    @Override
    public List<Users> findAll() {
        return userJpaRepository.findAll();
    }
}
