package com.cognologix.springboot.service;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.DepositWithdrawAmount;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.exception.AccountNotFoundException;
import com.cognologix.springboot.exception.EmptyListException;
import com.cognologix.springboot.exception.InSufficientBalanceException;
import com.cognologix.springboot.exception.NameAlreadyExistException;

public interface AccountService {
    AccountResponse addAccount(AccountDTO account) throws NameAlreadyExistException;

    Account getAccountById(int id) throws AccountNotFoundException;

    AccountListResponse getAccounts() throws EmptyListException;

    AccountResponse withdrawAmount(DepositWithdrawAmount withdrawAmount) throws InSufficientBalanceException, NullPointerException;

    AccountResponse depositAmount(DepositWithdrawAmount depositAmount) throws AccountNotFoundException, NullPointerException;

    void deleteAccount(int id);
}
