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
        this.weight = weight;
    }

    @Override
    public LocalDate expirationDate() {
        return null;
    }

    @Override
    public LocalDate isExpired() {
        return null;
    }

    @Override
    public String productDetails() {
        return "";
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return null;
    }

    @Override
    public BigDecimal weight() {
        return null;
    }
}
