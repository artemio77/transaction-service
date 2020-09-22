package com.gmail.derevets.artem.transactionservice.jpa;

import com.gmail.derevets.artem.transactionservice.entity.ClientEntity;
import com.gmail.derevets.artem.transactionservice.entity.TransactionEntity;
import com.gmail.derevets.artem.transactionservice.repository.ClientRepository;
import com.gmail.derevets.artem.transactionservice.repository.TransactionRepository;
import org.checkerframework.checker.units.qual.C;
import org.flywaydb.core.Flyway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;


@DataJpaTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class TransactionJpaTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void saveAllTest() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(12.213);
        transactionEntity.setCard("123456****1234");
        transactionEntity.setCurrency("UAN");
        transactionEntity.setPlace("Test Place");
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setInn("123456789");
        clientEntity.setFirstName("test");
        clientEntity.setLastName("test");
        clientEntity.setMiddleName("test");
        transactionEntity.setClient(clientEntity);
        List<TransactionEntity> transactionEntities = Collections.singletonList(transactionEntity);
        clientRepository.save(clientEntity);
        entityManager.flush();
        transactionRepository.saveAll(transactionEntities);
        Assert.assertEquals(transactionRepository.findAll().size(), transactionEntities.size());
        Assert.assertEquals(transactionRepository.findAll(), transactionEntities);
        Assert.assertEquals(clientRepository.findAll().size(), Collections.singletonList(clientEntity).size());
        Assert.assertEquals(clientRepository.findAll(), Collections.singletonList(clientEntity));
    }
}
