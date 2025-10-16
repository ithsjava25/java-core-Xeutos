package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Product {
    private UUID id;
    private String name;
    private Category category;
    private BigDecimal price;

    public Product(String name, Category category, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public UUID uuid() {
        return id;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }

    public void price(BigDecimal price) {
        if  (price.doubleValue() < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public abstract String productDetails();
}
