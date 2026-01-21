package com.example.BankAccountManagement.controller;

import com.example.BankAccountManagement.dto.AccountDTO;
import com.example.BankAccountManagement.entity.Account;
import com.example.BankAccountManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/create")
    public ResponseEntity<AccountDTO>createAccount(@RequestBody AccountDTO accountdto){
        AccountDTO create = service.createAccount(accountdto);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account>getAccount(@PathVariable Long id){
        Account get = service.getAccount(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO>updateAccount(@RequestBody AccountDTO accountdto,@PathVariable Long id){
        AccountDTO update = service.updateAccount(accountdto,id);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>closeAccount(@PathVariable Long id){
        service.closeAccount(id);
        return ResponseEntity.ok("Deleted successfully");
    }
    @GetMapping("getallaccounts")
    public List<Account> getAllAccountDetails(){
        List<Account> getall = service.getAllAccountDetails();
        return getall;
    }
    @PutMapping("deposit/{id}/{amount}")
    public ResponseEntity<Account> despositAmount(@PathVariable Long id, @PathVariable Double amount){
        Account update = service.depositAmount(id,amount);
        return ResponseEntity.ok(update);
    }
    @PutMapping("withdraw/{id}/{amount}")
    public ResponseEntity<Account>withdrawAmount(@PathVariable Long id, @PathVariable Double amount){
        Account update = service.withdrawAmount(id, amount);
        return ResponseEntity.ok(update);
    }
}
