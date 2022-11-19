package com.java.bankapplication.controllers;

import com.java.bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/create")
    public String showRegister() {
        return "register";
    }

}