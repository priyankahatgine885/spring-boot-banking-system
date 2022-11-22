package com.cognologix.springboot.service.impl;

import com.cognologix.springboot.dao.AccountDao;
import com.cognologix.springboot.dao.CustomerDao;
import com.cognologix.springboot.dto.bankaccount.AccountDTO;
import com.cognologix.springboot.dto.bankaccount.AccountListResponse;
import com.cognologix.springboot.dto.bankaccount.AccountResponse;
import com.cognologix.springboot.dto.bankaccount.TransferAmountDTO;
import com.cognologix.springboot.entities.Account;
import com.cognologix.springboot.entities.Customer;
import com.cognologix.springboot.exception.*;
import com.cognologix.springboot.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * The type Account service.
 */
@Service
@Log4j2
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public AccountResponse addAccount(AccountDTO accountDTO) throws DuplicateCustomerDetailsNotAllowed, CustomerNotFoundException {
        Customer customer = null;
        if (Objects.nonNull(accountDTO.getCustomerInfo().getId())) {
            customer = customerDao.findCustomerById(accountDTO.getCustomerInfo().getId());
            if (Objects.isNull(customer)) {
                throw new CustomerNotFoundException("Invalid customer ID.");
            }
        } else {
            customer = customerDao.save(new Customer(accountDTO.getCustomerInfo()));
        }
        Account account = new Account(accountDTO);
        account.setCustomerInfo(customer);
        account.setAccountNumber(generateAccountNumber());
        return new AccountResponse(accountDao.save(account));
    }

    @Override
    public Account getAccountById(int id) throws AccountNotFoundException {
        if ((id <= 0)) {
            throw new AccountNotFoundException("Account Not Exist" + id);
        }
        AccountDTO a = new AccountDTO(accountDao.findById(id).get());

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
    public AccountResponse withdrawAmount(String accountNumber, double amount) throws InSufficientBalanceException, CustomerNotFoundException, InvalidAmountException {
        Account account = accountDao.findAccountByAccountNumber(accountNumber);
        if (Objects.isNull(account)) {
            throw new CustomerNotFoundException("Invalid customer account number.");
        }
        if ((account.getBalance() < amount)) {
            throw new InSufficientBalanceException("InSufficient Balance. Transaction Failed..");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Amount should be positive number");
        }
        account.setBalance(account.getBalance() - amount);
        return new AccountResponse(accountDao.save(account));
    }

    @Override
    public AccountResponse depositAmount(String accountNumber, double amount) throws CustomerNotFoundException, InvalidAmountException {
        Account account = accountDao.findAccountByAccountNumber(accountNumber);
        if (Objects.isNull(account)) {
            throw new CustomerNotFoundException("Invalid customer account number.");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Amount should be positive number");
        }
        account.setBalance(account.getBalance() + amount);
        return new AccountResponse(accountDao.save(account));
    }

    @Override
    public void deleteAccount(int id) {
        Account entity = accountDao.getOne(id);
        if (accountDao.existsById(id)) {
            accountDao.delete(entity);
        } else {
            log.info("Account Not exist");
        }
    }

    @Override
    public void transferAmount(TransferAmountDTO transferAmountDTO) throws InSufficientBalanceException, CustomerNotFoundException, InvalidAmountException {
        if (transferAmountDTO.getAmount() < 0) {
            throw new InvalidAmountException("Amount should be positive number");
        }
        Account account = accountDao.findAccountByAccountNumber(transferAmountDTO.getFromAccountNumber());
        if (account.getBalance() >= 50000) {
            withdrawAmount(transferAmountDTO.getFromAccountNumber(), transferAmountDTO.getAmount());
        }
        depositAmount(transferAmountDTO.getToAccountNumber(), transferAmountDTO.getAmount());
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder card = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            int n = rand.nextInt(10);
            card.append(n);
        }
        return card.toString();

    }
}
