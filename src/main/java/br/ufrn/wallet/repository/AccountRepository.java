package br.ufrn.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufrn.wallet.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Query(value = "SELECT a FROM Account WHERE a.email = :email")
  Account findByEmail(@Param("email") String email);
}