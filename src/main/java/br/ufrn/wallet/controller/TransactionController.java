package br.ufrn.wallet.controller;

import br.ufrn.wallet.enums.CurrencyEnum;
import br.ufrn.wallet.enums.TransactionTypeEnum;
import br.ufrn.wallet.form.TransactionForm;
import br.ufrn.wallet.model.Transaction;
import br.ufrn.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    @Qualifier("transactionServiceImpl")
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity listTransactions() {
        try {
            Set<Transaction> transactions = transactionService.getListTransaction();
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
    public ResponseEntity createPayment(@RequestBody TransactionForm transactionForm) {
        Transaction transaction = new Transaction();
        transaction.setTitle(transactionForm.getTitle())
                .setValue(transaction.getValue())
                .setType(TransactionTypeEnum.valueOf(transactionForm.getType()))
                .setCurrency(CurrencyEnum.valueOf(transactionForm.getCurrency()));
        Transaction transactionSaved = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(transactionSaved, HttpStatus.OK);
    }
}
