package com.java.bankapplication.controller;

import com.java.bankapplication.exception.UserNotFoundException;
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
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return new ResponseEntity<>(
                "User is created successfully with ID = " + user.getId(),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUser() {
        List<User> userList = userService.getAllUser();
        if (userList.isEmpty()) {
            log.info("Empty User Repository!");
        }
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateUser(
            @PathVariable("id") Long id,
            @RequestBody User user) {
        boolean isUserExist = userService.isUserExist(id);
        if (isUserExist) {
            userService.updateUser(id, user);
            return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

}