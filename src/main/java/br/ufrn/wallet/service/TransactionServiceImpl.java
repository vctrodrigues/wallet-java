package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.model.Transaction;
import br.ufrn.wallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;
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
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getReferenceById(id);
    }

    @Override
    public Set<Transaction> listTransaction() {
        return transactionRepository.findAll(Sort.by(Sort.Direction.DESC, "date")).stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Transaction> listTransaction(Account account) {
        return transactionRepository.findByAccount(account).stream().collect(Collectors.toSet());
    }

    @Override
    public Map<Date, List<Transaction>> listTransactionGroupedByDate(Account account) {
        Set<Transaction> transactions = this.listTransaction(account);
        Map<Date, List<Transaction>> groupedTransactions = transactions.stream().map(transaction -> {
            Calendar c = Calendar.getInstance();
            c.setTime(transaction.getDate());
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            transaction.setDate(c.getTime());
            return transaction;
        }).collect(Collectors.groupingBy(Transaction::getDate));

        return groupedTransactions;
    }


}
