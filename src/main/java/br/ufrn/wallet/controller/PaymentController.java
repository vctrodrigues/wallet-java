package br.ufrn.wallet.controller;

import br.ufrn.wallet.form.PaymentForm;
import br.ufrn.wallet.model.Payment;
import br.ufrn.wallet.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    @Qualifier("paymentServiceImpl")
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity listPayments() {
        try {
            Set<Payment> payments = paymentService.getListPayment();
            return new ResponseEntity<>(payments, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("No payments found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPayment(@PathVariable(name = "id") Long id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            return new ResponseEntity<>(payment, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("No payment found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createPayment(@RequestBody PaymentForm paymentForm) {
        Payment payment = new Payment();
        payment.setCode(paymentForm.getCode())
                .setDescription(paymentForm.getDescription())
                .setValue(paymentForm.getValue());
        Payment paymentSaved = paymentService.createPayment(payment);
        return new ResponseEntity<>(paymentSaved, HttpStatus.OK);
    }
}
