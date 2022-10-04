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

    @GetMapping("/{accountId}/edit/{id}")
    public String accessBoxes(@PathVariable Long accountId, @PathVariable Long id, Model model) {
        List<MoneyBox> moneyBoxes = moneyBoxService.listMoneyBoxesByAccount(accountId);
        MoneyBox moneyBox = moneyBoxService.getMoneyBoxById(id);

        model.addAttribute("boxes", moneyBoxes);
        model.addAttribute("box", moneyBox);
        model.addAttribute("account", accountService.getAccountById(accountId));
        return "box/index";
    }

    @PostMapping("/{accountId}")
    public String createMoneyBox(@ModelAttribute MoneyBox box, @PathVariable Long accountId, Model model) {
        box.addParticipants(accountService.getAccountById(accountId));

        MoneyBox moneyBoxSaved = moneyBoxService.createMoneyBox(box);
        List<MoneyBox> moneyBoxes = moneyBoxService.listMoneyBoxesByAccount(accountId);

        model.addAttribute("boxes", moneyBoxes);
        model.addAttribute("box", new MoneyBox());
        model.addAttribute("account", accountService.getAccountById(accountId));

        return "box/index";
    }
}
