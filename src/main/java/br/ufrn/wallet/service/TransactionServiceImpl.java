package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Transaction;
import br.ufrn.wallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getReferenceById(id);
    }

    @Override
    public Set<Transaction> getListTransaction() {
        return transactionRepository.findAll().stream().collect(Collectors.toSet());
    }

}
