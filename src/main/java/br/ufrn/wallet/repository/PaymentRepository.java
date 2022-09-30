package br.ufrn.wallet.repository;

import br.ufrn.wallet.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
