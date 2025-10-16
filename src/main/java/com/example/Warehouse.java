package com.example;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    private String name;
    private static final Map<String, Warehouse> instances = new HashMap<>();

    private List<Product> warehouseInventory;

    private Warehouse(String name) {
        this.name = name;
        warehouseInventory = new ArrayList<>();
    }

    public static Warehouse getInstance(String name){

        name = name.substring(0, 1).toUpperCase() +  name.substring(1);

        String finalName = name;
        return instances.computeIfAbsent(name, newName
                -> {
            return new Warehouse(finalName);
        });
    }

    public void addProduct(Product product){
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        warehouseInventory.add(product);
    }

    public List<Product> getWarehouseInventory(){
        return warehouseInventory;
    }

    public Optional<Product> getProductById(UUID id) {
        return warehouseInventory.stream().filter(product -> product.uuid().equals(id)).findFirst();
    }

    public void updateProductPrice(UUID id, BigDecimal price){
        if (warehouseInventory.stream().noneMatch(product -> product.uuid().equals(id))){
            throw new NoSuchElementException("Product not found with id: ");
        } else {
            warehouseInventory.stream()
                    .filter(product -> product.uuid().equals(id))
                    .findFirst()
                    .ifPresent(product -> {
                        product.price(price);
                    });
        }
    }

    public List<Perishable> expiredProducts(){
        List<Perishable> expiredProducts = new ArrayList<>();
        warehouseInventory.stream().filter(product -> product instanceof Perishable).forEach(product -> {
            expiredProducts.add((Perishable) product);
        });
        return expiredProducts;
    }

    public List<Shippable> shippableProducts(){
        List<Shippable> shippableProducts = new ArrayList<>();
        warehouseInventory.stream().filter(product -> product instanceof Shippable).forEach(product -> {
            shippableProducts.add((Shippable) product);
        });
        return shippableProducts;
    }

    public void remove(UUID id){
        warehouseInventory.removeIf(product -> product.uuid().equals(id));
    }

    public void clearProducts(){
        warehouseInventory.clear();
    }

    public boolean isEmpty(){
        return warehouseInventory.isEmpty();
    }

    //todo figure out how to return products as categories in a map.
    public Map<Category, Product> getProductsGroupedByCategories() {
        Map<Category, List<Product>> groupedByCategories = new HashMap<>();
        return null;
    }

    //todo figure out what using interface means.
}
