package com.jpa.play.ui.controller;

import com.jpa.play.persistence.model.Users;
import com.jpa.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{name}")
    @ResponseBody
    public ResponseEntity<Users> findByName(@PathVariable final String name) {
        Users users =  userService.findByName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/findAll")
    @ResponseBody
    public ResponseEntity<List<Users>> findAll() {
        List<Users> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

 //    @PostMapping(value ="/load")
//    public User load(@RequestBody final User user) {
//        userService.save(user);
//        return userService.findByName(user.getName());
//    }

}

