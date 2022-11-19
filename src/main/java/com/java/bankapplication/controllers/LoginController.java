package com.java.bankapplication.controllers;

import com.java.bankapplication.service.LoginService;
import com.java.bankapplication.service.Mailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    public static String uname;
    @Autowired
    LoginService loginService;

    @Autowired
    Mailservice mailService;

    @RequestMapping("/login")
    public String loginMessage() {
        return "login";
    }
}
