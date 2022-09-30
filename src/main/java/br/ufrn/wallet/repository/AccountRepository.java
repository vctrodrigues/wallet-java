package br.ufrn.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.wallet.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}