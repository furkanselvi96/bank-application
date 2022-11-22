package com.java.bankapplication.service;

import com.java.bankapplication.model.entity.User;
import com.java.bankapplication.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public List<User> getAllUser() {
        return userJpaRepository.findAll();
    }

    public void updateUser(Long id, User user) {
        User updateUser = userJpaRepository.findUserById(user.getId());
        updateUser.setName(user.getName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        userJpaRepository.save(updateUser);
    }

    public User createUser(User user) {
        char[] tcNumbers = user.getTc().toCharArray();
        //if Tc is empty || tc length is not 11 || Tc No first number is cannot be zero.
        if (user.getTc() == null || user.getTc().length() != 11 || tcNumbers[0] == 0) {
            System.out.println("Wrong TC No!");
            return null;
        }
        List<User> allUsers = userJpaRepository.findAll();
        List<String> usersTc = new ArrayList<>();
        for (User dbUser : allUsers) {
            usersTc.add(dbUser.getTc());
        }
        if (usersTc.contains(user.getTc())) {
            log.info("TC No already exist!");
            return null;
        }
        return userJpaRepository.save(user);
    }

    public boolean isUserExist(Long id) {
        Set<Long> userIdSet = new HashSet<>();
        userIdSet.addAll(userJpaRepository.findAllUserId());
        if (!userIdSet.contains(id)){
            return false;
        }else
            return true;
    }

}
