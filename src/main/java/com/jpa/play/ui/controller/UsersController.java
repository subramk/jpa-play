package com.jpa.play.ui.controller;

import com.jpa.play.service.UserService;
import com.jpa.play.persistence.model.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping(value="/users/findAll")
    @ResponseBody
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = userService.findAll();
        return ResponseEntity.ok(users);

    }

    @GetMapping(value="/users/{name}")
    @ResponseBody
    public Users findByName(@PathVariable final String name ){
        return userService.findByName(name);
    }


//    @PostMapping(value ="/load")
//    public User load(@RequestBody final User user) {
//        userService.save(user);
//        return userService.findByName(user.getName());
//    }

}