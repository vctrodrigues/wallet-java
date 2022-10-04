package br.ufrn.wallet.controller;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ufrn.wallet.model.Expense;
import br.ufrn.wallet.service.ExpenseService;

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

  @GetMapping("/edit/{accountId}/{id}")
  public String listExpenses(@PathVariable Long accountId, @PathVariable Long id, Model model) {
    Account account = accountService.getAccountById(accountId);
    Expense expense = expenseService.getExpenseById(id);

    model.addAttribute("account", account);
    model.addAttribute("expenses", expenseService.listExpenses(account));
    model.addAttribute("expense", expense);

    return "expense/index";
  }

  @PostMapping("/{accountId}")
  public String createExpense(@PathVariable Long accountId, @ModelAttribute Expense expense, Model model) {
    expense.setAccount(accountService.getAccountById(accountId));
    Expense expenseSaved = expenseService.saveExpense(expense);
    return this.listExpenses(accountId, model);
  }

  @DeleteMapping("/{accountId}/{id}")
  public String deleteExpense(@PathVariable Long id, @PathVariable Long accountId, Model model) {
    expenseService.deleteExpense(id);
    return this.listExpenses(accountId, model);
  }

  @PatchMapping("/{accountId}/{id}")
  public String editEXpenses(@PathVariable Long id, @PathVariable Long accountId, @ModelAttribute Expense expense,
      Model model) {
    Expense e = expenseService.getExpenseById(id);
    e.setDescription(expense.getDescription()).setDay(expense.getDay());
    expenseService.saveExpense(e);

    return this.listExpenses(accountId, model);
  }

}
