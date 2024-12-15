package com.example.BookManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //@Entity: Marks the class as a JPA entity.
public class Book {
    @Id // Specifies the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates IDs for new entities.
    private Long id;
    private String title;
    private String author;
    private double price;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
