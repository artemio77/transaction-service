package com.gmail.derevets.artem.transactionservice.api.v1.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;
@XmlType(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable {
    @XmlElement(name = "inn", required = true)
    private String inn;
    @XmlElement(name = "firstName", required = true)
    private String firstName;
    @XmlElement(name = "lastName", required = true)
    private String lastName;
    @XmlElement(name = "middleName", required = true)
    private String middleName;

    public Client() {
    }

    public Client(String inn, String firstName, String lastName, String middleName) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(inn, client.inn) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(middleName, client.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn, firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "Client{" +
                "inn='" + inn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
