package com.jpa.play.service;


import com.jpa.play.persistence.model.Users;
import com.jpa.play.persistence.repository.UserJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

   @Autowired
   private UserJpaRepository  userJpaRepository;


    public Users findByName(String name){
        return userJpaRepository.findByName(name);
    }

    @Override
    public List<Users> findAll() {
        //return of(Users.builder().id(5L).name("kasi").build());
        return userJpaRepository.findAll();
    }
}