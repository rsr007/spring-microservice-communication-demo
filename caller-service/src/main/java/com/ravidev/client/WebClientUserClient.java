package com.ravidev.client;


import com.ravidev.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUserClient {

    private WebClient webClient;

    WebClientUserClient(WebClient.Builder builder){
        webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public User getUser(long id){
        return webClient.get()
                .uri("/user/{id}",id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public User addUser(User user){
        return webClient.get()
                .uri("/user")
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
