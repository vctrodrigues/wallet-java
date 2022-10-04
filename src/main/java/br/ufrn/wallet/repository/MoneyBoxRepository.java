package br.ufrn.wallet.repository;

import br.ufrn.wallet.model.MoneyBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoneyBoxRepository extends JpaRepository<MoneyBox, Long> {
    List<MoneyBox> findByParticipants_Id(Long id);
}
