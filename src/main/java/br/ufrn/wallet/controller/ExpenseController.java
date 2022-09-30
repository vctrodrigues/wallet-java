package br.ufrn.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufrn.wallet.model.Expense;
import br.ufrn.wallet.model.ExpenseForm;
import br.ufrn.wallet.service.ExpenseService;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

  @Autowired
  @Qualifier("expenseServiceImpl")
  ExpenseService expenseService;

  @GetMapping()
  public String listExpenses(Model model) {
    model.addAttribute("expenses", expenseService.getExpenses());
    return "/";
  }

  @GetMapping("/{id}")
  public String listExpenses(@PathVariable long id, Model model) {
    Expense expense = expenseService.getExpenseById(id);
    model.addAttribute("expense", expense);
    return "/";
  }

  @PatchMapping("/{id}")
  public String updateExpense(@PathVariable long id, Model model, @RequestBody ExpenseForm expenseForm) {
    Expense expense = expenseService.getExpenseById(id);
    expense.setDay(expenseForm.getDay()).setCurrency(expenseForm.getCurrency())
        .setDescription(expenseForm.getDescription()).setValue(expenseForm.getValue());

    expenseService.saveExpense(expense);

    return this.listExpenses(model);
  }

  @PostMapping()
  public String createExpense(Model model, @RequestBody ExpenseForm expenseForm) {
    Expense expense = new Expense();

    expense.setDay(expenseForm.getDay()).setCurrency(expenseForm.getCurrency())
        .setDescription(expenseForm.getDescription()).setValue(expenseForm.getValue());

    expenseService.saveExpense(expense);

    return this.listExpenses(model);
  }
}
