package com.gmail.derevets.artem.transactionservice.api.v1.service;

import com.gmail.derevets.artem.transactionservice.api.v1.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> bulkSave(List<Transaction>transactions);
}
