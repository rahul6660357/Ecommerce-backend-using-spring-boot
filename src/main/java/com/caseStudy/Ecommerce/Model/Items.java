package com.caseStudy.Ecommerce.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    private String name;
    private double price;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    private String details;
    private String image;
    private String catogory;
    private String subcatogory;
    @Column(nullable = false,columnDefinition = "int default '1'")
    private int active;

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getImage() {
        return image;
    }

    public Items() {
    }

    public Items(String name, double price, String details, String image, String catogory, String subcatogory, int active) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.image = image;
        this.catogory = catogory;
        this.subcatogory = subcatogory;
        this.active = active;

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(double price) {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails(String details) {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage(String image) {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatogory() {
        return catogory;
    }

    public void setCatogory(String catogory) {
        this.catogory = catogory;
    }

    public String getSubcatogory() {
        return subcatogory;
    }

    public void setSubcatogory(String subcatogory) {
        this.subcatogory = subcatogory;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }



}
