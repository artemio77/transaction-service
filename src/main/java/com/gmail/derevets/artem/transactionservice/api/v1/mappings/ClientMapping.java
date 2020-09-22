package com.gmail.derevets.artem.transactionservice.api.v1.mappings;

import com.gmail.derevets.artem.transactionservice.api.v1.model.Client;
import com.gmail.derevets.artem.transactionservice.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ClientMapping {
    private final ModelMapper mapper;

    public ClientMapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() {
        toEntity();
        toRest();
    }

    private void toRest() {
        mapper.createTypeMap(ClientEntity.class, Client.class);
    }

    private void toEntity() {
        mapper.createTypeMap(Client.class, ClientEntity.class);
    }
}
