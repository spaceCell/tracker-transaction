package org.kirill.space.cell.tracker_transaction.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.kirill.space.cell.tracker_transaction.entity.Transaction;
import org.kirill.space.cell.tracker_transaction.mapper.TransactionMapper;
import org.kirill.space.cell.tracker_transaction.repository.TransactionRepository;
import org.kirill.space.cell.tracker_transaction.service.TransactionService;
import org.kirill.space.cell.tracker_transaction.transactionServiceDto.TransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::transactionToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.dtoToTransaction(transactionDto);
        transactionRepository.save(transaction);
        return transactionDto;
    }

//    private TransactionDto toDto(Transaction transaction) {
//        return new TransactionDto(
//                transaction.getId(),
//                transaction.getToken(),
//                transaction.getAmount(),
//                transaction.getCreatedAt()
//        );
//    }
//
//    private Transaction toEntity(TransactionDto transactionDto) {
//        return new Transaction(
//                transactionDto.getToken(),
//                transactionDto.getAmount()
//        );
//    }
}
