package com.cognologix.springboot.service.impl;

import com.cognologix.springboot.dto.BaseResponse;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.InSufficientBalanceException;
import com.cognologix.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private static List<Account> accountList = new ArrayList<>();
    @Override
    public BaseResponse addAccount(Account acc) {
        Account account = new Account();
        if(accountList != null) {
            account.setAccountNumber(acc.getAccountNumber());
            account.setFullName(acc.getFullName());
            account.setPhone(acc.getPhone());
            account.setBalance(acc.getBalance());
            accountList.add(account);
        }
        return new AccountResponse(account);
    }

    @Override
    public void displayAnAccount(String accountNumber) throws AccountNotFoundException {
        if (accountList != null) {
            for (Account arr : accountList) {
                if(arr != null) {
                    if (arr.getAccountNumber().equals(accountNumber)) {
                        System.out.println(arr.toString());
                        break;
                    }
                }
            }
            throw new AccountNotFoundException("Account Not Exist");
        }
    }

    @Override
    public BaseResponse displayAllAccounts() throws AccountNotFoundException {
        if (accountList == null) {
            throw new AccountNotFoundException("Account number not found.");
        }
        return new AccountListResponse(accountList, accountList.size());
    }

    @Override
    public void withdraw(String accountNumber) throws InSufficientBalanceException, AccountNotFoundException {
        long amount = 0;
        double balance;
        System.out.println("Enter Amount you Want to withdraw : ");
       // amount = sc.nextLong();
        if (accountList != null) {
            for (Account account : accountList) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    if (account.getBalance() >= amount) {
                        balance = account.getBalance() - amount;
                        account.setBalance(balance);
                        System.out.println(account.toString());
                        break;
                    } else {
                        throw new InSufficientBalanceException("Less Balance..Transaction Failed..");
                    }
                }
                System.out.println("Account Number Not Found");
            }
        }
    }

    @Override
    public void deposit(String accountNumber) throws AccountNotFoundException {
        long amount = 0;
        double balance;
        System.out.println("Enter Amount you Want to Deposit : ");
       // amount = sc.nextLong();
        if (accountList != null) {
            for (Account account : accountList) {
                if (account != null) {
                    if (account.getAccountNumber().equals(accountNumber)) {
                        balance = account.getBalance() + amount;
                        account.setBalance(balance);
                        System.out.println(account.toString());
                        break;
                    }
                }
            }
        }
        System.out.println("Account Number Not Exist");
    }

    @Override
    public boolean removeAnAccount(String accountNumber) {
        if (accountList != null) {
            Account account = new Account();
            account.setAccountNumber(accountNumber);
            if(accountList.contains(account)) {
                accountList.remove(account);
                return true;
            }else {
                System.out.println("Account Not exist");
            }
        }
        return false;
    }
}
