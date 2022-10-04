package br.ufrn.wallet.service;

import java.util.List;

import br.ufrn.wallet.model.Account;
import org.springframework.stereotype.Service;

import br.ufrn.wallet.model.Expense;

@Service
public interface ExpenseService {

    public Expense saveExpense(Expense expense);

    public void deleteExpense(Long id);

    public Expense getExpenseById(Long id);

    public List<Expense> listExpenses();

    public List<Expense> listExpenses(Account account);

}
