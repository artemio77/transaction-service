package com.gmail.derevets.artem.transactionservice.api.v1.mappings;

import com.gmail.derevets.artem.transactionservice.api.v1.model.Transaction;
import com.gmail.derevets.artem.transactionservice.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TransactionMapping {
    private final ModelMapper mapper;

    public TransactionMapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() {
        toEntity();
        toRest();
    }

    private void toRest() {
        mapper.createTypeMap(TransactionEntity.class, Transaction.class)
                .addMappings(mapper -> mapper.map(TransactionEntity::getClient, Transaction::setClient));

    }

    private void toEntity() {
        mapper.createTypeMap(Transaction.class, TransactionEntity.class)
                .addMappings(mapper -> mapper.map(Transaction::getClient, TransactionEntity::setClient));
    }
}
