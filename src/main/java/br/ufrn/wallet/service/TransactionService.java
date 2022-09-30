package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TransactionService {
    
    public Transaction createTransaction(Transaction transaction);
    public void deleteTransaction(Transaction transaction);
    public Transaction getTransactionById(Long id);
    public Set<Transaction> getListTransaction();

}
