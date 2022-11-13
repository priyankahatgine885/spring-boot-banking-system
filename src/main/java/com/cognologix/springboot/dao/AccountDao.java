package com.cognologix.springboot.dao;
import com.cognologix.springboot.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
   Account findAccountByAccountNumber(String accountNumber);
}
