package br.ufrn.wallet.controller;

import br.ufrn.wallet.model.MoneyBox;
import br.ufrn.wallet.service.AccountService;
import br.ufrn.wallet.service.MoneyBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boxes")
public class MoneyBoxController {

    @Autowired
    @Qualifier("moneyBoxServiceImpl")
    private MoneyBoxService moneyBoxService;

    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public String accessBoxes(@PathVariable Long accountId, Model model) {
        List<MoneyBox> moneyBoxes = moneyBoxService.listMoneyBoxesByAccount(accountId);

        model.addAttribute("boxes", moneyBoxes);
        model.addAttribute("box", new MoneyBox());
        model.addAttribute("account", accountService.getAccountById(accountId));
        return "box/index";
    }

    @PostMapping("/{account_id}")
    public String createMoneyBox(@ModelAttribute MoneyBox moneyBox, @PathVariable Long account_id, Model model) {
        MoneyBox moneyBoxSaved = moneyBoxService.createMoneyBox(moneyBox);
        List<MoneyBox> moneyBoxes = moneyBoxService.listMoneyBoxesByAccount(account_id);

        model.addAttribute("boxes", moneyBoxes);
        model.addAttribute("box", new MoneyBox());
        model.addAttribute("account", accountService.getAccountById(account_id));

        return "box/index";
    }
}
