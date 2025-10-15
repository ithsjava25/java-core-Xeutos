package com.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable {
    private int warrantyMonths;
    private BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);
        if  (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        }
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;
    }

    @Override
    public String productDetails() {
        return "Electronics: " + name() + ", Warranty: " + warrantyMonths + " months";
    }

    @Override
    public BigDecimal calculateShippingCost() {
        if (weight.doubleValue() < 5)
            return BigDecimal.valueOf(128);
        return BigDecimal.valueOf(79);
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
