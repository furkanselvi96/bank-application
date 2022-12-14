package com.java.bankapplication.controller;

import com.java.bankapplication.exception.UserNotFoundException;
import com.java.bankapplication.model.entity.User;
import com.java.bankapplication.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "User Api Documentation")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "New user create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        boolean checkResponse = false;
        checkResponse = userService.createUser(user);
        if (checkResponse)
            return new ResponseEntity<>(
                    "User is created successfully with ID = " + user.getId(), HttpStatus.CREATED);
        else
            return new ResponseEntity<>("User is not created", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ApiOperation(value = "Get all users")
    public ResponseEntity<Object> getAllUser() {
        List<User> userList = userService.getAllUser();
        if (userList.isEmpty()) {
            throw new UserNotFoundException();
        }
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update user")
    public ResponseEntity<Object> updateUser(
            @PathVariable(value = "id") Long id,
            @RequestBody User user) {
        boolean isUserExist = userService.isUserExist(id);
        boolean checkResponse = false;
        if (isUserExist) {
            checkResponse = userService.updateUser(id, user);
            if (checkResponse)
                return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Prohibited Transaction ", HttpStatus.FORBIDDEN);
        }
        throw new UserNotFoundException();
    }

}