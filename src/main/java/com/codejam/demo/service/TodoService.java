package com.codejam.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Value("${todo.url}")
    String todoUrl;

    private final RestTemplate restTemplate;


    public ResponseEntity<String> getTodo(String id) {

    String response =   restTemplate.getForObject(todoUrl + id,String.class);
    Optional<String> responseOptional = Optional.ofNullable(response);

        return ResponseEntity.of(responseOptional);
    }


}
