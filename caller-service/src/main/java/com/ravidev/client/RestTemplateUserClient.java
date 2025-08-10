package com.ravidev.client;

import com.ravidev.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestTemplateUserClient {

    String USER_SERVICE_URL = "http://localhost:8080/user/{id}";
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @param id if
     * @return
     */
    public User getUser(long id){
        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", id);
        User user = restTemplate.getForObject(USER_SERVICE_URL, User.class, uriVariables);
        //restTemplate.getForEntity(USER_SERVICE_URL, User.class, uriVariables);
        //restTemplate.exchange(USER_SERVICE_URL, HttpMethod.GET, null, User.class, uriVariables);
        System.out.println(user);
        return user;
    }

    public void addUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        //set any key value in headers as per your requirement
        headers.set("auth","bearer-token");
        headers.set("content-type","application/json");
        HttpEntity<User> entity = new HttpEntity<>(user,headers);
        ResponseEntity responseEntity = restTemplate.exchange(USER_SERVICE_URL, HttpMethod.POST,entity,User.class);
        System.out.println(String.format("addUser using rest-template, status: {}",responseEntity.getStatusCode()));
    }
}
