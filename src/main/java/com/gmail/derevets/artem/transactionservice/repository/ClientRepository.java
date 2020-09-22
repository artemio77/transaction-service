package com.gmail.derevets.artem.transactionservice.repository;

import com.gmail.derevets.artem.transactionservice.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {
}
