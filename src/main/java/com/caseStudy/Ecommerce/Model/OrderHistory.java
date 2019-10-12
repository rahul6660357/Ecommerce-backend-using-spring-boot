package com.caseStudy.Ecommerce.Model;

import javax.persistence.*;

import java.time.LocalDate;
@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne
    private Items items;
    @ManyToOne
    private Users users;

    @Column
    private int quantity;

    @Column
    private int price;

    @Column(nullable = false)
    private LocalDate date;



    public LocalDate getDate(){
        date =LocalDate.now();
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderHistory() {
    }

    public OrderHistory(Items items, Users users, int quantity, int price, LocalDate date) {
        this.items = items;
        this.users = users;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
}
