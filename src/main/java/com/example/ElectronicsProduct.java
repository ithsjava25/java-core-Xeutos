package com.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable {
    private int warrantyMonths;
    private BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight) {
        super(id, name, category, price);
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;
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
