package com.service.layer;


import java.util.List;

import com.jpa.play.persistence.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.play.persistence.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public User findByName(String name){
        return userJpaRepository.findByName(name);

    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll();
    }
}
