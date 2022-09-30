package br.ufrn.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.wallet.model.Expense;

@Service
public interface ExpenseService {

    public Expense createExpense(Expense expense);

    public void deleteExpense(Expense expense);

    public Expense getExpenseById(Integer id);

    public List<Expense> getListExpense();

}
