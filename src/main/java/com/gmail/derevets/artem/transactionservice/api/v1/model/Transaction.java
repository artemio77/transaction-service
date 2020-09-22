package com.gmail.derevets.artem.transactionservice.api.v1.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "transaction", propOrder = {
        "place",
        "amount",
        "currency","card","client"
})
public class Transaction implements Serializable {

    @XmlElement(name = "place")
    private String place;
    @XmlElement(name = "amount")
    private Double amount;
    @XmlElement(name = "currency")
    private String currency;
    @XmlElement(name = "card")
    private String card;
    @XmlElement(name = "client", type = Client.class)
    private Client client;

    public Transaction() {
    }

    public Transaction(String place, Double amount, String currency, String card, Client client) {
        this.place = place;
        this.amount = amount;
        this.currency = currency;
        this.card = card;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(place, that.place) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(card, that.card) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, amount, currency, card, client);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "place='" + place + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", card='" + card + '\'' +
                ", client=" + client +
                '}';
    }
}
