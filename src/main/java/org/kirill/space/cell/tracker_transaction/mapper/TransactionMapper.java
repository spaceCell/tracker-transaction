package org.kirill.space.cell.tracker_transaction.mapper;

import org.kirill.space.cell.tracker_transaction.entity.Transaction;
import org.kirill.space.cell.tracker_transaction.transactionServiceDto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "createdAt", source = "createdAt")
    TransactionDto transactionToDto(Transaction transaction);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Transaction dtoToTransaction(TransactionDto transactionDto);
}
