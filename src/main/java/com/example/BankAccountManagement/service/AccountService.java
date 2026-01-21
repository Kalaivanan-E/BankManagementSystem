package com.example.BankAccountManagement.service;

import com.example.BankAccountManagement.dto.AccountDTO;
import com.example.BankAccountManagement.entity.Account;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountdto);
    Account getAccount(Long id);
    AccountDTO updateAccount(AccountDTO accountdto, Long id);
    void deleteAccount(Long id);
}
