package com.java.bankapplication.service;

import com.java.bankapplication.model.Transaction;
import com.java.bankapplication.repository.DataRepository;
import com.java.bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShowService {

    @Autowired
    DataRepository dataRepository;
    @Autowired
    UserRepository userRepository;

    public int addAdmin(String name, String username, String accno,
                        int mobno, String address, int ifsc, int balance) {
        return userRepository.addAdmin(name, username, accno, mobno, address, ifsc, balance);
    }

    public int addAdminLogin(String username, String password, String role) {
        return userRepository.addAdminLogin(username, password, role);
    }

    public List<Transaction> showTransaction(String uname) {
        return dataRepository.showTransaction(uname);
    }
}
