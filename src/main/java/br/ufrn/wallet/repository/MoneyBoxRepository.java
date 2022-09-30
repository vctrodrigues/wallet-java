package br.ufrn.wallet.repository;

import br.ufrn.wallet.model.MoneyBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyBoxRepository extends JpaRepository<MoneyBox, Long> {
}
