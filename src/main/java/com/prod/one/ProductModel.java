package com.prod.one;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "PRODUCTS")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private double quantity;
    private int customerId;

    @CreationTimestamp
    private LocalDate createdDate;

    @CreationTimestamp
    private LocalTime createdTime;

    @ManyToOne
    @JoinColumn(name = "client_id" ,nullable = false)
    @JsonBackReference
    private ClientModel client;

    public ProductModel() {
    }

    public ProductModel(int id, double quantity, int customerId, LocalDate createdDate, LocalTime createdTime, ClientModel client) {

        this.id = id;
        this.quantity = quantity;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
