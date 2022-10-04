package br.ufrn.wallet.controller;

import br.ufrn.wallet.model.Expense;
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
    public String listBoxes(@PathVariable Long accountId, Model model) {
        List<MoneyBox> moneyBoxes = moneyBoxService.listMoneyBoxesByAccount(accountId);

        model.addAttribute("boxes", moneyBoxes);
        model.addAttribute("box", new MoneyBox());
        model.addAttribute("account", accountService.getAccountById(accountId));
        model.addAttribute("accounts", accountService.getAccounts());
        return "box/index";
    }

    @PostMapping("/{accountId}")
    public String createMoneyBox(@ModelAttribute MoneyBox box, @PathVariable Long accountId, Model model) {
        box.addParticipants(accountService.getAccountById(accountId));

        MoneyBox moneyBoxSaved = moneyBoxService.createMoneyBox(box);

        return this.listBoxes(accountId, model);
    }

    @PostMapping("/delete/{accountId}/{id}")
    public String deleteExpense(@PathVariable Long id, @PathVariable Long accountId, Model model) {
        moneyBoxService.deleteMoneyBox(id);
        return this.listBoxes(accountId, model);
    }

    @PostMapping("/add/{accountId}/{id}")
    public String addMoneyToMoneyBox(@PathVariable Long id, @PathVariable Long accountId,
            @ModelAttribute MoneyBox moneyBox,
            Model model) {
        MoneyBox b = moneyBoxService.getMoneyBoxById(id);
        b.setValue(moneyBox.getValue() + b.getValue());
        moneyBoxService.createMoneyBox(b);

        return this.listBoxes(accountId, model);
    }

    @PostMapping("/include/{id}/{accountId}")
    public String includePerson(@PathVariable Long id, @PathVariable Long accountId,
            Model model) {
        MoneyBox b = moneyBoxService.getMoneyBoxById(id);
        b.addParticipants(accountService.getAccountById(accountId));
        moneyBoxService.createMoneyBox(b);

        return this.listBoxes(accountId, model);
    }

    @PostMapping("/edit/{accountId}/{id}")
    public String editMoneyBox(@PathVariable Long id, @PathVariable Long accountId, @ModelAttribute MoneyBox moneyBox,
            Model model) {
        MoneyBox b = moneyBoxService.getMoneyBoxById(id);
        b.setValue(moneyBox.getValue()).setName(moneyBox.getName());
        moneyBoxService.createMoneyBox(b);

        return this.listBoxes(accountId, model);
    }
}
