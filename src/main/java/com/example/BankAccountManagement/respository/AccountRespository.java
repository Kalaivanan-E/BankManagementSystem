package com.example.BankAccountManagement.respository;

import com.example.BankAccountManagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account, Long> {
    Account findByid(Long id);
}
