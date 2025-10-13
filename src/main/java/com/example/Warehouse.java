package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Warehouse {
    private String name;

    public static Warehouse getInstance(String name){
        return new Warehouse();
    }

    public void addProduct(Product product){
    }

    public List<Product> getProducts(){
        return new ArrayList<>();
    }

    public List<Product> getProductById(UUID id){
        return new ArrayList<>();
    }

    public void updateProductPrice(UUID id, BigDecimal price){}

    public List<Perishable> expiredProducts(){
        return new ArrayList<>();
    }

    public List<Shippable> shippableProducts(){
        return new ArrayList<>();
    }

    public void remove(UUID id){

    }

    public void clearProducts(){
    }

    public boolean isEmpty(){
        return false;
    }

    public boolean isTrue(){
        return false;
    }

    public boolean getProductsGroupedByCategories() {
        return false;
    }
}
