package com.java.bankapplication.controllers;

import com.java.bankapplication.service.LoginService;
import com.java.bankapplication.service.Mailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class LoginController {
	
	public static String uname;
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String loginMessage(){
		return "login";
	}

}
