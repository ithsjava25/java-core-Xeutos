package com.example;

import java.math.BigDecimal;

public interface Shippable {
    double weight = 0.0;

    BigDecimal calculateShippingCost();

    default double weight(){
        return weight;
    }
}
