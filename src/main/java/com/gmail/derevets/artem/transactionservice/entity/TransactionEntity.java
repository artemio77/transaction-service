package com.gmail.derevets.artem.transactionservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {@org.hibernate.annotations.Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
            )
            }
    )
    private UUID id;

    @Column(name = "place")
    private String place;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency", length = 5)
    private String currency;


    @Column(name = "card", length = 16)
    private String card;

    @ManyToOne(optional = false)
    private ClientEntity client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(place, that.place) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(card, that.card) &&
                Objects.equals(client, that.client);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, amount, currency, card, client);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", amount=" + amount +
                ", currency=" + currency +
                ", card='" + card + '\'' +
                ", client=" + client +
                '}';
    }
}
