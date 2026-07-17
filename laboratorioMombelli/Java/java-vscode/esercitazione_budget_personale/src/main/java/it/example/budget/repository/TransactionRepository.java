package it.example.budget.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.example.budget.entity.Transaction;
import it.example.budget.entity.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserOrderByDateDesc(User user);

    List<Transaction> findByUserAndCategory(User user, String category);

    List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}
