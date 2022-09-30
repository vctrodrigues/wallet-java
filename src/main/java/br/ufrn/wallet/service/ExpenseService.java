package br.ufrn.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.wallet.model.Expense;

@Service
public interface ExpenseService {

    public Expense saveExpense(Expense expense);

    public void deleteExpense(Expense expense);

    public Expense getExpenseById(long id);

    public List<Expense> getExpenses();

}
