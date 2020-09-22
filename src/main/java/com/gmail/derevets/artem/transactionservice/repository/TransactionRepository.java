package com.gmail.derevets.artem.transactionservice.repository;

import com.gmail.derevets.artem.transactionservice.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
