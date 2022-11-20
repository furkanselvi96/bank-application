package com.java.bankapplication.service;

import com.java.bankapplication.model.entity.User;
import com.java.bankapplication.model.request.UserRequest;
import com.java.bankapplication.model.response.UserResponse;
import com.java.bankapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUser() {

        List<User> userList = userRepository.findAll();
        UserResponse userResponse = new UserResponse();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            userResponse.setTc(userList.get(i).getTcNum());
            userResponse.setName(userList.get(i).getFirstName());
            userResponseList.add(userResponse);
        }
        /*
        user.ifPresent(u -> {
            userResponse.setName(u.getFirstName());
            userResponse.setTc(u.getTcNum());
            userResponse.setName(u.getFirstName());
        });*/
        return userResponseList;
    }

    public void createUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
    }
}
