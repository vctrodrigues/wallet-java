package br.ufrn.wallet.service;

import br.ufrn.wallet.model.Payment;
import br.ufrn.wallet.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.getReferenceById(id);
    }

    @Override
    public Set<Payment> getListPayment() {
        return paymentRepository.findAll().stream().collect(Collectors.toSet());
    }
}
