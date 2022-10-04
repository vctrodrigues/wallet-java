package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface TransactionService {

    public Transaction createTransaction(Transaction transaction);

    public void deleteTransaction(Long id);

    public Transaction getTransactionById(Long id);

    public Set<Transaction> listTransaction();

    public Set<Transaction> listTransaction(Account account);

    public Map<Date, List<Transaction>> listTransactionGroupedByDate(Account account);

}
