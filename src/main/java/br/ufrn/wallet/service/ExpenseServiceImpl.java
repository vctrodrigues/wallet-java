package br.ufrn.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.wallet.model.Expense;

@Component
public class ExpenseServiceImpl {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        return expenseRepository.delete(expense);
    }

    @Override
    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(id).map(expense -> {
            return expense;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Expense> getListExpense() {
        return expenseRepository.findAll();
    }

}
