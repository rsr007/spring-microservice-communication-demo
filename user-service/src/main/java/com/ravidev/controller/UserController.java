package com.ravidev.controller;

import com.ravidev.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        System.out.println(String.format("Request for user with Id: {}",id));
        User user = User.builder()
                .id(id)
                .name("Ravi")
                .email("learn@gmail.com")
                .build();
        return new ResponseEntity(user, OK);
    }

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user){
        System.out.println(String.format("Post request to add user: {}",user));
        return new ResponseEntity(OK);
    }

}
