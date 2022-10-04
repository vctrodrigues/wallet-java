package br.ufrn.wallet.repository;

import br.ufrn.wallet.model.Account;
import br.ufrn.wallet.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.account = ?1 ORDER BY date DESC, id DESC")
    public Set<Transaction> findByAccount(@Param("account") Account account);
}
