package br.ufrn.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.wallet.model.Transaction;

@Component
public class TransactionServiceImple implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        return transactionRepository.delete(transaction);
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).map(transaction -> {
            return transaction;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Transaction> getListTransaction() {
        return transactionRepository.findAll();
    }

}
