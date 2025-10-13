package com.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Warehouse {
    private String name;

    public String getInstance(String name){
        return name;
    }

    public void addProduct(Product product){
    }

    public List<Product> getProducts(){
        return null;
    }

    public List<Product> getProductById(UUID id){
        return null;
    }

    public void updateProductPrice(UUID id, BigDecimal price){}

    public List<Perishable> expiredProducts(){
        return null;
    }

    public List<Shippable> shippableProducts(){
        return null;
    }

    public void remove(UUID id){

    }
}
