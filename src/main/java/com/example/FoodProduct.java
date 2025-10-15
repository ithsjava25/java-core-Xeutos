package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product implements Perishable, Shippable {
    private LocalDate expirationDate;
    private BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        super(id, name, category, price);
        this.expirationDate = expirationDate;
        if (price.doubleValue() <0.0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (weight.doubleValue() <0.0) {
            throw new  IllegalArgumentException("Weight cannot be negative.");
        }
        this.weight = weight;
    }

    @Override
    public LocalDate expirationDate() {
        return expirationDate;
    }

    @Override
    public String productDetails() {
        return "Food: " + name() + ", Expires: " + expirationDate;
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return BigDecimal.valueOf(weight()*50);
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
