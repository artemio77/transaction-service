package com.gmail.derevets.artem.transactionservice.api.v1.service.impl;

import com.gmail.derevets.artem.transactionservice.api.v1.model.Transaction;
import com.gmail.derevets.artem.transactionservice.api.v1.service.TransactionService;
import com.gmail.derevets.artem.transactionservice.entity.ClientEntity;
import com.gmail.derevets.artem.transactionservice.entity.TransactionEntity;
import com.gmail.derevets.artem.transactionservice.repository.ClientRepository;
import com.gmail.derevets.artem.transactionservice.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public TransactionServiceImpl(ModelMapper modelMapper,
                                  TransactionRepository transactionRepository,
                                  ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Transaction> bulkSave(List<Transaction> transactions) {
        List<TransactionEntity> transactionEntities = transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionEntity.class))
                .collect(Collectors.toList());
        List<ClientEntity> clientEntities = transactionEntities.stream().map(TransactionEntity::getClient).collect(Collectors.toList());
        clientRepository.saveAll(clientEntities);
        return transactionRepository.saveAll(transactionEntities).stream()
                .map(transactionEntity -> modelMapper.map(transactionEntity, Transaction.class))
                .collect(Collectors.toList());
    }


}
