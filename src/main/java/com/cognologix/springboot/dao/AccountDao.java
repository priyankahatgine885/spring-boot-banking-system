package com.cognologix.springboot.dao;

import com.cognologix.springboot.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Account dao.
 */
public interface AccountDao extends JpaRepository<Account, Integer> {
    /**
     * Find account by account number account.
     *
     * @param accountNumber the account number
     * @return the account
     */
    Account findAccountByAccountNumber(String accountNumber);
}
