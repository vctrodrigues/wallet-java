package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Payment;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PaymentService {

    public Payment createPayment(Payment payment);

    public void deletePayment(Long id);

    public Payment getPaymentById(Long id);

    public Set<Payment> getListPayment();
}
