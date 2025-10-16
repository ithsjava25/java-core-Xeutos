package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable {
    private int warrantyMonths;
    private BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(name, category, price);
        if  (warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        }
        this.warrantyMonths = warrantyMonths;
        if (weight.doubleValue() <0.0) {
            throw new  IllegalArgumentException("Weight cannot be negative.");
        }
        this.weight = weight;
    }

    @Override
    public String productDetails() {
        return "Electronics: " + name() + ", Warranty: " + warrantyMonths + " months";
    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal shippingPrice = BigDecimal.valueOf(79);
        if (weight.doubleValue() > 5)
            shippingPrice = shippingPrice.add(BigDecimal.valueOf(49));
        return shippingPrice;
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
