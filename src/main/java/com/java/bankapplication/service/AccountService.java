package com.java.bankapplication.service;

import com.java.bankapplication.model.entity.Account;
import com.java.bankapplication.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountJpaRepository accountJpaRepository;

    public List<Account> getUserAccounts(Long userId) {
        List<Account> userAccounts = accountJpaRepository.findByUserId(userId);
        if (userAccounts.isEmpty()){
            log.info("User's bank account not found");
            return null;
        }
        return userAccounts;
    }




}
