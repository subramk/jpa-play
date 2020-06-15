package com.ui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.play.persistence.model.User;
import com.service.layer.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    //TODO - Remove after fixing serialization issue
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping(value="/users/findAll")
    @ResponseBody
    public ResponseEntity<String> findAll() {
        List<User> users = userService.findAll();

        //FIXME - fix serialization issue with the project and remove the bespoke serialization code
        // and reply on spring to do the serialization work
        //ISSUE - There is an issue serializing to JSON,
        // See below the error :
        // DefaultHandlerExceptionResolver :
        // Resolved [org.springframework.http.converter.HttpMessageNotWritableException:
        // No converter found for return value of type: class java.util.ArrayList]
        //return ResponseEntity.ok(users);
        try {
            String json = mapper.writeValueAsString(users);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping(value="/users/{name}")
    @ResponseBody
    public User findByName(@PathVariable final String name ){
        return userService.findByName(name);
    }


//    @PostMapping(value ="/load")
//    public User load(@RequestBody final User user) {
//        userService.save(user);
//        return userService.findByName(user.getName());
//    }

}