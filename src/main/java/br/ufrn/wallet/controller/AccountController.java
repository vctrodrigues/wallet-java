package br.ufrn.wallet.controller;

import br.ufrn.wallet.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  @Qualifier("accountServiceImpl")
  AccountService accountService;

  @PostMapping()
  public String getAccount(Model model, @RequestBody LoginForm loginForm) {
    Account account = accountService.getAccountByEmail(loginForm.getEmail());
    model.addAttribute("account", account);
    return "/";
  }

  @GetMapping()
  public String listAccounts(Model model) {
    model.addAttribute("accounts", accountService.getAccounts());
    return "/";
  }
}
