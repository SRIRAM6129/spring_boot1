package com.prod.one;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENT")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)

    private Gender gender;
    private String PhoneNumber;
    private String adhaarNumber;
    private String accountNumber;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<ProductModel> products;

    public ClientModel() {
    }

    public ClientModel(int id, String name, Gender gender, String phoneNumber, String adhaarNumber, String accountNumber, List<ProductModel> products) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        PhoneNumber = phoneNumber;
        this.adhaarNumber = adhaarNumber;
        this.accountNumber = accountNumber;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", adhaarNumber='" + adhaarNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", products=" + products +
                '}';
    }
}

