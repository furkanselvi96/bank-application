package com.java.bankapplication.service;

import com.java.bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	
	
	public boolean isValid(String username, String password) {
		
		return userRepository.search(username,password);
		
	}
}
