package com.cottin.webservice.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String zipCode;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client id(int id) {
        setId(id);
        return this;
    }

    public Client lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Client firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Client address(String address) {
        setAddress(address);
        return this;
    }

    public Client city(String city) {
        setCity(city);
        return this;
    }

    public Client zipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return id == client.id && Objects.equals(lastName, client.lastName) && Objects.equals(firstName, client.firstName) && Objects.equals(address, client.address) && Objects.equals(city, client.city) && Objects.equals(zipCode, client.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, city, zipCode);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            "}";
    }

}