package com.example.BankAccountManagement.service.impl;

import com.example.BankAccountManagement.dto.AccountDTO;
import com.example.BankAccountManagement.entity.Account;
import com.example.BankAccountManagement.respository.AccountRespository;
import com.example.BankAccountManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceimpl implements AccountService {
    @Autowired
    private AccountRespository repo;

    public AccountDTO createAccount(AccountDTO accountdto){
        Account A1 = new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );
        Account savedA1 = repo.save(A1);
        return new AccountDTO(
                savedA1.getId(),
                savedA1.getAccountHolderName(),
                savedA1.getBalance()
        );
    }
    public Account getAccount(Long id){
        return repo.findByid(id);
    }
    public AccountDTO updateAccount(AccountDTO accountdto, Long id){
        Account A2 = repo.findByid(id);
        A2.setAccountHolderName(accountdto.getAccountHolderName());
        A2.setBalance(accountdto.getBalance());
        Account savedA2 = repo.save(A2);
        return new AccountDTO(
                savedA2.getId(),
                savedA2.getAccountHolderName(),
                savedA2.getBalance()
        );
    }
    public void  closeAccount(Long id){
        Account del = repo.findByid(id);
        repo.delete(del);
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> listofall = repo.findAll();
        return listofall;
    }
}
