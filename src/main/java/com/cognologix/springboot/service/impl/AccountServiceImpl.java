package com.cognologix.springboot.service.impl;

import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.DepositWithdrawAmount;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.exception.InSufficientBalanceException;
import com.cognologix.springboot.exception.NameAlreadyExistException;
import com.cognologix.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountResponse addAccount(AccountDTO acc) throws NameAlreadyExistException {
        if (accountDao.findAccountByAccountNumber(acc.getAccountNumber()) != null) {
            throw new NameAlreadyExistException("Account already exist");
        } else {
            return new AccountResponse(accountDao.save(new Account(acc)));
        }
    }

    @Override
    public Account getAccountById(int id) throws AccountNotFoundException {
        if ((id <= 0)) {
            throw new AccountNotFoundException("Account Not Exist" + id);
        }
        return accountDao.findById(id).get();

    }

    @Override
    public AccountListResponse getAccounts() throws EmptyListException {
        List<Account> accountList = accountDao.findAll();
        if (accountList.isEmpty()) {
            throw new EmptyListException("Account List is empty");
        }
        return new AccountListResponse(accountList, accountList.size());
    }

    @Override
    public AccountResponse withdrawAmount(DepositWithdrawAmount withdrawAmount) throws InSufficientBalanceException, NullPointerException {
        double balance;
        Account account = accountDao.findAccountByAccountNumber(withdrawAmount.getAccountNumber());
        if (account == null) {
            throw new NullPointerException("Null Pointer Exception");
        } else {
            if (account.getAccountNumber().equals(withdrawAmount.getAccountNumber())) {
                if (account.getBalance() >= withdrawAmount.getAmount()) {
                    balance = account.getBalance() - withdrawAmount.getAmount();
                    account.setBalance(balance);
                } else {
                    throw new InSufficientBalanceException("Less Balance..Transaction Failed..");
                }
            }
        }
        return new AccountResponse(accountDao.save(account));
    }

    @Override
    public AccountResponse depositAmount(DepositWithdrawAmount depositAmount) throws AccountNotFoundException, NullPointerException {
        double balance;
        Account account = accountDao.findAccountByAccountNumber(depositAmount.getAccountNumber());
        if (account == null) {
            throw new NullPointerException("Null Pointer Exception");
        } else {
            if (account.getAccountNumber().equals(depositAmount.getAccountNumber())) {
                balance = account.getBalance() + depositAmount.getAmount();
                account.setBalance(balance);
            } else {
                throw new AccountNotFoundException("Account Not Exist");
            }
        }
        return new AccountResponse(accountDao.save(account));
    }

    @Override
    public void deleteAccount(int id) {
        Account entity = accountDao.getOne(id);
        if (accountDao.existsById(id)) {
            accountDao.delete(entity);
        } else {
            System.out.println("Account Not exist");
        }
    }
}
