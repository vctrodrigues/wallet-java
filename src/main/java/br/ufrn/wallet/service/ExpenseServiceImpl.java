package br.ufrn.wallet.service;

import java.util.List;

import br.ufrn.wallet.model.Account;
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
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).map(expense -> {
            return expense;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Expense> listExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> listExpenses(Account account) {
        return expenseRepository.findByAccount(account);
    }
}
