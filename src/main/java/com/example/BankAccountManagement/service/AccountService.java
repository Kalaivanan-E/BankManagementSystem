package com.example.BankAccountManagement.service;

import com.example.BankAccountManagement.dto.AccountDTO;
import com.example.BankAccountManagement.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountdto);
    Account getAccount(Long id);
    AccountDTO updateAccount(AccountDTO accountdto, Long id);
    void closeAccount(Long id);
    public List<Account> getAllAccountDetails();
//    public Account depositAmount(Long id, Double amount);
//    public Account withdrawAmount(Long id, Double amount);


}
