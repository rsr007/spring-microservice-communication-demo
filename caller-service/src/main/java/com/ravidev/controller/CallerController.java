package com.ravidev.controller;

import com.ravidev.client.FeignUserClient;
import com.ravidev.client.RestTemplateUserClient;
import com.ravidev.client.WebClientUserClient;
import com.ravidev.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CallerController {

    @Autowired
    RestTemplateUserClient restTemplateUserClient;
    @Autowired
    WebClientUserClient webClientUserClient;
    @Autowired
    FeignUserClient feignUserClient;

    @GetMapping("/rest-template/user/{id}")
    public ResponseEntity<User> getUserViaRestTemplate(@PathVariable long id){
        User user = restTemplateUserClient.getUser(id);
        return new ResponseEntity<>(user,OK);
    }

    @GetMapping("/web-client/user/{id}")
    public ResponseEntity<User> getUserViaWebClient(@PathVariable long id){
        User user = webClientUserClient.getUser(id);
        return new ResponseEntity<>(user,OK);
    }

    @GetMapping("/feign-client/user/{id}")
    public ResponseEntity<User> getUserViaFeignClient(@PathVariable long id){
        User user = feignUserClient.getUser(id);
        return new ResponseEntity<>(user,OK);
    }
}
