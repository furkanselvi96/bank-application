package com.java.bankapplication.service;

import com.java.bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignUpService {

    @Autowired
    UserRepository userRepository;

}
