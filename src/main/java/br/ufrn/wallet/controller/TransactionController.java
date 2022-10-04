package br.ufrn.wallet.controller;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.model.Transaction;
import br.ufrn.wallet.service.AccountService;
import br.ufrn.wallet.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    @Qualifier("transactionServiceImpl")
    TransactionService transactionService;

    @Autowired
    @Qualifier("accountServiceImpl")
    AccountService accountService;

    @GetMapping
    public ResponseEntity listTransactions() {
        try {
            Set<Transaction> transactions = transactionService.listTransaction();
            return new ResponseEntity<>(transactions, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("No transactions found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTransaction(@PathVariable(name = "id") Long id) {
        try {
            Transaction transaction = transactionService.getTransactionById(id);
            return new ResponseEntity<>(transaction, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("No transaction found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public String createTransaction(@ModelAttribute Transaction transaction, Model model) {
        transaction.setCurrency(CurrencyEnum.BRL);
        Transaction transactionSaved = transactionService.createTransaction(transaction);
        Map<Date, List<Transaction>> groupedTransactions = transactionService.listTransactionGroupedByDate(transactionSaved.getAccount());

        model.addAttribute("transactions", groupedTransactions);
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("account", accountService.getAccountById(transaction.getAccount().getId()));

        return "account/index";
    }
}
