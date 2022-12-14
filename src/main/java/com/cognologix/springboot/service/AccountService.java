package com.cognologix.springboot.service;

import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.TransferAmountDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.exception.*;

/**
 * The interface Account service.
 */
public interface AccountService {
    /**
     * Add account account response.
     *
     * @param account the account
     * @return the account response
     * @throws DuplicateCustomerDetailsNotAllowed the name already exist exception
     * @throws CustomerNotFoundException          the customer not found exception
     */
    AccountResponse addAccount(AccountDTO account) throws DuplicateCustomerDetailsNotAllowed, CustomerNotFoundException;

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return the account by id
     * @throws AccountNotFoundException the account not found exception
     */
    Account getAccountById(int id) throws AccountNotFoundException;

    /**
     * Gets accounts.
     *
     * @return the accounts
     * @throws EmptyListException the empty list exception
     */
    AccountListResponse getAccounts() throws EmptyListException;

    /**
     * Withdraw amount account response.
     *
     * @param accountNo the account no
     * @param amount    the amount
     * @return the account response
     * @throws InSufficientBalanceException the in sufficient balance exception
     * @throws CustomerNotFoundException    the customer not found exception
     * @throws InvalidAmountException       the invalid amount exception
     */
    AccountResponse withdrawAmount(String accountNo, double amount) throws InSufficientBalanceException, CustomerNotFoundException, InvalidAmountException;

    /**
     * Deposit amount account response.
     *
     * @param accountNo the account no
     * @param amount    the amount
     * @return the account response
     * @throws AccountNotFoundException  the account not found exception
     * @throws NullPointerException      the null pointer exception
     * @throws CustomerNotFoundException the customer not found exception
     * @throws InvalidAmountException    the invalid amount exception
     */
    AccountResponse depositAmount(String accountNo, double amount) throws AccountNotFoundException, NullPointerException, CustomerNotFoundException, InvalidAmountException;

    /**
     * Delete account.
     *
     * @param id the id
     */
    void deleteAccount(int id);

    /**
     * Transfer amount.
     *
     * @param transferAmountDTO the transfer amount dto
     * @throws AccountNotFoundException     the account not found exception
     * @throws InSufficientBalanceException the in sufficient balance exception
     * @throws CustomerNotFoundException    the customer not found exception
     * @throws InvalidAmountException       the invalid amount exception
     */
    void transferAmount(TransferAmountDTO transferAmountDTO) throws AccountNotFoundException, InSufficientBalanceException, CustomerNotFoundException, InvalidAmountException;
}
