package br.ufrn.wallet.service;

import java.util.List;

import br.ufrn.wallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.wallet.model.Account;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.findById(id).map(account -> {
            return account;
        }).orElseThrow(() -> null);
    }

    @Override
    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

}
