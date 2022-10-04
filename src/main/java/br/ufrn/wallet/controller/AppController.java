package br.ufrn.wallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ufrn.wallet.model.Account;

@Controller
@RequestMapping("/")
public class AppController {

  @GetMapping()
  public String access(Model model) {
    model.addAttribute("account", new Account());
    return "index";
  }

}