package com.java.bankapplication.controller;

import com.java.bankapplication.model.entity.User;
import com.java.bankapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAllUser();
        if (userList.isEmpty()) {
            log.info("Empty User Repository!");
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

}