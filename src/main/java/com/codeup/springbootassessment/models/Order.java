package com.codeup.springbootassessment.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double totalPrice;

    public Order() {
    }

    public Order(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Order(long orderNumber, String email) {
        this.orderNumber = orderNumber;
        this.email = email;
    }

    public Order(long orderNumber, String email, double totalPrice) {
        this.orderNumber = orderNumber;
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}