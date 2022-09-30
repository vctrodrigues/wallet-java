package br.ufrn.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufrn.wallet.model.Expense;
import br.ufrn.wallet.form.ExpenseForm;
import br.ufrn.wallet.service.ExpenseService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

  @Autowired
  @Qualifier("expenseServiceImpl")
  ExpenseService expenseService;

  @GetMapping
  public ResponseEntity listExpenses() {
    try {
      List<Expense> expenses = expenseService.getExpenses();
      return new ResponseEntity<>(expenses, HttpStatus.OK);

    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>("No expenses found.", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity getExpense(@PathVariable(name = "id") Long id) {
    try {
      Expense expense = expenseService.getExpenseById(id);
      return new ResponseEntity<>(expense, HttpStatus.OK);

    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>("No expense found.", HttpStatus.NOT_FOUND);
    }
  }

  @PatchMapping("/{id}")
  public ResponseEntity updateExpense(@PathVariable(name = "id") Long id, @RequestBody ExpenseForm expenseForm) {
    try {
      Expense expense = expenseService.getExpenseById(id);
      expense.setDay(expenseForm.getDay())
              .setCurrency(expenseForm.getCurrency())
              .setDescription(expenseForm.getDescription())
              .setValue(expenseForm.getValue());
      Expense expenseSaved = expenseService.saveExpense(expense);
      return new ResponseEntity<>(expenseSaved, HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity("No expense found with given id: "+ id, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity createExpense(@RequestBody ExpenseForm expenseForm) {
    Expense expense = new Expense();
    expense.setDay(expenseForm.getDay())
            .setCurrency(expenseForm.getCurrency())
            .setDescription(expenseForm.getDescription())
            .setValue(expenseForm.getValue());
    Expense expenseSaved = expenseService.saveExpense(expense);
    return new ResponseEntity<>(expenseSaved, HttpStatus.OK);
  }
}
