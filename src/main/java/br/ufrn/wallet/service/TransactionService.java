package br.ufrn.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    
    public Transaction createTransaction(Transaction transaction);
    public void deleteTransaction(Transaction transaction);
    public Transaction getTransactionById(Integer id);
    public List<Transaction> getListTransaction();

}
