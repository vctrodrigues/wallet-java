package br.ufrn.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.wallet.model.Account;

@Service
public interface AccountService {

    public Account createAccount(Account account);

    public void deleteAccount(Long id);

    public Account getAccountById(Long id);

    public Account getAccountByEmail(String email);

    public List<Account> getAccounts();

}