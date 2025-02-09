package org.kirill.space.cell.tracker_transaction.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.kirill.space.cell.tracker_transaction.service.TransactionService;
import org.kirill.space.cell.tracker_transaction.transactionServiceDto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDto addTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        log.info("Adding transaction: {}", transactionDto);
        return transactionService.saveTransaction(transactionDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDto> getAllTransactions() {
        log.info("Fetching all transactions");
        return transactionService.getAllTransactions();
    }
}
