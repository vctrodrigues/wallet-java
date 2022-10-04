package br.ufrn.wallet.controller;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @Autowired
  @Qualifier("accountServiceImpl")
  AccountService accountService;

  @GetMapping("/{id}")
  public String listExpenses(@PathVariable Long id, Model model) {
    Account account = accountService.getAccountById(id);
    model.addAttribute("account", account);
    model.addAttribute("expenses", expenseService.listExpenses(account));
    model.addAttribute("expense", new Expense());

    return "expense/index";
  }

  @PostMapping("/{id}")
  public String createExpense(@PathVariable Long id, @ModelAttribute Expense expense, Model model) {
    Expense expenseSaved = expenseService.saveExpense(expense);
    return this.listExpenses(id, model);
  }

  @DeleteMapping("/{accountId}/{id}")
  public String deleteExpense(@PathVariable Long id, @PathVariable Long accountId, Model model) {
    expenseService.deleteExpense(id);
    return this.listExpenses(accountId, model);
  }

  @PatchMapping("/{accountId}/{id}")
  public String editEXpenses(@PathVariable Long id, @PathVariable Long accountId, @ModelAttribute Expense expense, Model model) {
    Expense e = expenseService.getExpenseById(id);
    e.setDescription(expense.getDescription()).setDay(expense.getDay());
    expenseService.saveExpense(e);

    return this.listExpenses(accountId, model);
  }


}
