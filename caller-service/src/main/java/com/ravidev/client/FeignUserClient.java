package com.ravidev.client;

import com.ravidev.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="user-service", url = "http://localhost:8080")
public interface FeignUserClient {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") long id);

    @PostMapping("/user")
    ResponseEntity addUser();
}
