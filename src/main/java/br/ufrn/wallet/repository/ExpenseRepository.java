package br.ufrn.wallet.repository;

import br.ufrn.wallet.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.wallet.model.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public List<Expense> findByAccount(Account account);
}