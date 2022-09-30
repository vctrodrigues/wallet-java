package br.ufrn.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.wallet.model.Transaction;

@Service
public interface TransactionService {

    public Transaction createTransaction(Transaction transaction);

    public void deleteTransaction(Transaction transaction);

    public Transaction getTransactionById(Integer id);

    public List<Transaction> getListTransaction();

}
