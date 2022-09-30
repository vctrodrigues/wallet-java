package br.ufrn.wallet.service;

import java.util.List;

import br.ufrn.wallet.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.wallet.model.Expense;

@Component
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        expenseRepository.delete(expense);
    }

    @Override
    public Expense getExpenseById(long id) {
        return expenseRepository.findById(id).map(expense -> {
            return expense;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }
}
