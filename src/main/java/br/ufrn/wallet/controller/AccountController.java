package br.ufrn.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.model.Transaction;
import br.ufrn.wallet.service.AccountService;
import br.ufrn.wallet.service.TransactionService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  @Qualifier("accountServiceImpl")
  AccountService accountService;

  @Autowired
  @Qualifier("transactionServiceImpl")
  TransactionService transactionService;

  @PostMapping()
  public String signin(@ModelAttribute Account account, Model model) {
    Account _account = accountService.getAccountByEmail(account.getEmail());
    Map<Date, List<Transaction>> groupedTransactions = transactionService
        .listTransactionGroupedByDate(_account);

    Transaction transaction = new Transaction();
    transaction.setAccount(_account);

    model.addAttribute("transactions", groupedTransactions);
    model.addAttribute("account", _account);
    model.addAttribute("transaction", transaction);

    return "account/index";
  }

  @GetMapping("/{id}")
  public String getAccount(@PathVariable Long id, Model model) {
    Account account = accountService.getAccountById(id);
    Map<Date, List<Transaction>> groupedTransactions = transactionService
            .listTransactionGroupedByDate(account);

    Transaction transaction = new Transaction();
    transaction.setAccount(account);

    model.addAttribute("transactions", groupedTransactions);
    model.addAttribute("account", account);
    model.addAttribute("transaction", transaction);
    return "account/index";
  }

  @GetMapping("/expenses/{id}")
  public String accessExpenses(@PathVariable Long id, Model model) {
    model.addAttribute("account", accountService.getAccountById(id));
    return "expense/index";
  }
}