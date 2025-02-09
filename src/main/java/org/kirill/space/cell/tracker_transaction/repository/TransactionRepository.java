package org.kirill.space.cell.tracker_transaction.repository;

import org.kirill.space.cell.tracker_transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
