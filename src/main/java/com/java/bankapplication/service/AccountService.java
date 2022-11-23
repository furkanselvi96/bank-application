package com.java.bankapplication.service;

import com.java.bankapplication.model.Transaction;
import com.java.bankapplication.model.entity.Account;
import com.java.bankapplication.repository.AccountJpaRepository;
import com.java.bankapplication.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final String CURRENCY_TR = "TR";
    private final String CURRENCY_DOLLAR = "USD";
    private final String CURRENCY_EURO = "EURO";
    private final AccountJpaRepository accountJpaRepository;
    private final UserJpaRepository userJpaRepository;

    public List<Account> getUserAccounts(Long userId) {
        List<Account> userAccounts = accountJpaRepository.findByUserId(userId);
        if (userAccounts == null || userAccounts.isEmpty()) {
            log.info("User's bank account not found");
            return null;
        }
        return userAccounts;
    }

    public Account createAccount(Long userId, Account account) {
        Set<Long> userIdSet = userJpaRepository.findAllUserId();
        if (!userIdSet.contains(userId))
            return null;
        account.setUserId(userId);
        String currency = account.getCurrency();
        if (!(currency.equals(CURRENCY_DOLLAR) || currency.equals(CURRENCY_TR) || currency.equals(CURRENCY_EURO)))
            return null;
        account.setCurrency(account.getCurrency());
        accountJpaRepository.save(account);
        return account;
    }

    public String deleteAccount(Long accountId) {
        Set<Long> accountIds = accountJpaRepository.findAllAccountId();
        if (!accountIds.contains(accountId)) {
            return "Account does not exist!";
        }
        accountJpaRepository.deleteById(accountId);
        return "Account is deleted.";
    }

    public String moneyTransfer(Transaction transaction) {
        Account sendingAccount = accountJpaRepository.findAccountById(transaction.getSendingAccountId());
        Account receivingAccount = accountJpaRepository.findAccountById(transaction.getReceivingAccountId());
        boolean isSameUser = Objects.equals(sendingAccount.getUserId(), receivingAccount.getUserId());
        boolean isSameCurrency = sendingAccount.getCurrency().equals(receivingAccount.getCurrency());
        Long sendingBalance = sendingAccount.getBalance();
        Long receivingBalance = receivingAccount.getBalance();

        if (isSameCurrency && sendingBalance > 0 && sendingBalance >= transaction.getSendingAccountId()) {
            if (isSameUser) {
                sendingAccount.setBalance(sendingBalance - transaction.getTransactionAmount());
                receivingAccount.setBalance(receivingBalance + transaction.getTransactionAmount());
            } else {
                if (transaction.getNote() == null) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please write a description.");
                    String note = scanner.nextLine();
                    transaction.setNote(note);
                    moneyTransfer(transaction);
                } else {
                    sendingAccount.setBalance(sendingBalance - transaction.getTransactionAmount());
                    receivingAccount.setBalance(receivingBalance + transaction.getTransactionAmount());
                }
            }
            accountJpaRepository.save(sendingAccount);
            accountJpaRepository.save(receivingAccount);
            return "Transfer is Done";
        } else {
            if (!isSameCurrency && sendingAccount.getBalance() <= 0)
                return "Insufficient Balance and Difference Currency";
            else if (sendingAccount.getBalance() <= 0)
                return "Insufficient Balance";
            else
                return "Difference Currency";
        }
    }
}
