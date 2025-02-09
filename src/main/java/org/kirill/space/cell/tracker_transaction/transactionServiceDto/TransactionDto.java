package org.kirill.space.cell.tracker_transaction.transactionServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TransactionDto {

    private UUID id;
    private String token;
    private int amount;
    private LocalDateTime createdAt;
}
