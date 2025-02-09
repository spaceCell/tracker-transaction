package org.kirill.space.cell.tracker_transaction.service;

import org.kirill.space.cell.tracker_transaction.transactionServiceDto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getAllTransactions();

    TransactionDto saveTransaction(TransactionDto transaction);
}
