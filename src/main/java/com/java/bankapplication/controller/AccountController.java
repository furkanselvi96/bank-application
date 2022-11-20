package com.java.bankapplication.controller;

import com.java.bankapplication.model.entity.Account;
import com.java.bankapplication.model.entity.User;
import com.java.bankapplication.service.AccountService;
import com.java.bankapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/account")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<List<Account>> getUserAccounts(
            @PathVariable Long userId) {
        List<Account> userAccounts = accountService.getUserAccounts(userId);
        return new ResponseEntity<List<Account>>(userAccounts, HttpStatus.OK);
    }
    

}
