package com.java.bankapplication.controller;

import com.java.bankapplication.model.request.UserRequest;
import com.java.bankapplication.model.response.UserResponse;
import com.java.bankapplication.repository.UserRepository;
import com.java.bankapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(path = "create")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        log.info("User created");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        log.info("Get All Users");
        return ResponseEntity.ok(userService.getAllUser());
    }

}