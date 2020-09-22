package com.gmail.derevets.artem.transactionservice.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "client")
public class ClientEntity {

    @Id
    @Column(length = 10)
    private String inn;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "middleName")
    private String middleName;

    @OneToMany(mappedBy = "client")
    private List<TransactionEntity> transactionEntities;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<TransactionEntity> getTransactionEntities() {
        return transactionEntities;
    }

    public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
        this.transactionEntities = transactionEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(inn, that.inn) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(transactionEntities, that.transactionEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn, firstName, lastName, middleName, transactionEntities);
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "inn='" + inn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", transactionEntities=" + transactionEntities +
                '}';
    }
}
