package com.gmail.derevets.artem.transactionservice.api.v1.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransactionsResponse", propOrder = {"transactions"})
@XmlRootElement(name = "GetTransactionsResponse", namespace = "http://dbo.qulix.com/ukrsibdbo")
public class GetTransactionsResponse implements Serializable {

    @XmlElement(name = "transaction")
    @XmlElementWrapper(name="transactions")
    private List<Transaction> transactions;


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTransactionsResponse that = (GetTransactionsResponse) o;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        return "GetTransactionsResponse{" +
                "transactions=" + transactions +
                '}';
    }
}
