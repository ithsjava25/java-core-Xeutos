package com.example;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private final String name;

    private static final Map<String, Category> categories = new HashMap<>();

    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name){
        if (name == null)
            throw new IllegalArgumentException("Category name can't be null");
        if (name.isBlank())
            throw new IllegalArgumentException("Category name can't be blank");

        name = name.substring(0, 1).toUpperCase() +  name.substring(1);

        String finalName = name;
        return categories.computeIfAbsent(name, newName
                -> {
            return new Category(finalName);
        });
    }

    public String getName(){
        return name;
    }
}
