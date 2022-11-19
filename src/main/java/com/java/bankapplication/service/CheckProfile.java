package com.java.bankapplication.service;

import com.java.bankapplication.model.User;
import com.java.bankapplication.repository.DataRepository;
import com.java.bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckProfile {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DataRepository dataRepository;

    public List<User> getDetails(String username) {
        return userRepository.getDetails(username);
    }

    public List<User> getAll(String role) {

        return dataRepository.getAll(role);
    }
}
