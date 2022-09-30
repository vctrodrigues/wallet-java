package br.ufrn.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.wallet.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}