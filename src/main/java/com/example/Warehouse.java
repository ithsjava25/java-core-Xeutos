package com.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private static Map<String, Warehouse> instances = new HashMap<>();
    private static Warehouse defaultInstance = null;

    private List<Product> warehouseInventory;

    private Warehouse() {
        String name = "default";
        warehouseInventory = new ArrayList<>() ;
    }

    private Warehouse(String name) {
        warehouseInventory = new ArrayList<>();
    }

    public static Warehouse getInstance() {
        if  (defaultInstance == null) {
            defaultInstance = new Warehouse();
        }
        return defaultInstance;
    }

    public static Warehouse getInstance(String name) {
        return instances.computeIfAbsent(name, newName
                -> new Warehouse(name));
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        if (warehouseInventory.stream().anyMatch(p -> p.uuid().equals(product.uuid())))
            throw new IllegalArgumentException("Product already exists.");
        warehouseInventory.add(product);

        //warehouseInventory.stream().anyMatch(p -> p.uuid().equals(product.uuid()))
    }

    public List<Product> getWarehouseInventory() {
        return warehouseInventory;
    }

    public List<Product> getProducts(){
        return warehouseInventory.stream().toList();
    }

    public Optional<Product> getProductById(UUID id) {
        return warehouseInventory.stream().filter(product -> product.uuid().equals(id)).findFirst();
    }

    public void updateProductPrice(UUID id, BigDecimal price) {
        if (warehouseInventory.stream().noneMatch(product -> product.uuid().equals(id))) {
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

    public List<Perishable> expiredProducts() {
        List<Perishable> expiredProducts = new ArrayList<>();
        warehouseInventory.stream().filter(product -> product instanceof Perishable)
                .filter(product -> ((Perishable) product).isExpired())
                .forEach(product -> {
                    expiredProducts.add((Perishable) product);
                });
        return expiredProducts;
    }

    public List<Shippable> shippableProducts() {
        List<Shippable> shippableProducts = new ArrayList<>();
        warehouseInventory.stream().filter(product -> product instanceof Shippable).forEach(product -> {
            shippableProducts.add((Shippable) product);
        });
        return shippableProducts;
    }

    public void remove(UUID id) {
        warehouseInventory.removeIf(product -> product.uuid().equals(id));
    }

    public void clearProducts() {
        warehouseInventory.clear();
    }

    public boolean isEmpty() {
        return warehouseInventory.isEmpty();
    }

    public Map<Category, List<Product>> getProductsGroupedByCategories() {
        return warehouseInventory.stream().collect(Collectors.groupingBy(Product::category));
    }
}
