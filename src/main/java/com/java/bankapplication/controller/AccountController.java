package com.java.bankapplication.controller;

import com.java.bankapplication.model.Transaction;
import com.java.bankapplication.model.entity.Account;
import com.java.bankapplication.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/account")
@Slf4j
@Api(value = "Account Api Documentation")
public class AccountController {

    private final AccountService accountService;

    @GetMapping(path = "/{userId}")
    @ApiOperation(value = "Get a User Accounts")
    public ResponseEntity<List<Account>> getUserAccounts(
            @PathVariable Long userId) {
        List<Account> userAccounts = accountService.getUserAccounts(userId);
        return new ResponseEntity<List<Account>>(userAccounts, HttpStatus.OK);
    }

    @PostMapping(path = "/{userId}")
    @ApiOperation(value = "Create new account for a User")
    public ResponseEntity<Account> createAccount(
            @PathVariable Long userId,
            @RequestBody Account accountRequest) {
        Account account = accountService.createAccount(userId, accountRequest);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{accountId}")
    @ApiOperation(value = "Delete user account")
    public ResponseEntity<HttpStatus> deleteAccount(
            @PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/transfer")
    @ApiOperation(value = "Money Transfer Operations")
    public ResponseEntity<Object> moneyTransfer(
            @RequestBody Transaction transaction) {
        accountService.moneyTransfer(transaction);
        return new ResponseEntity<>("Transfer transaction is completed.",HttpStatus.OK);
    }


}
