package com.example;

public class Category {
    String name;

    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name){
        if (name == null)
            throw new IllegalArgumentException("Category name is null");
        if (name.isBlank())
            throw new IllegalArgumentException("Category name is blank");

        return new Category(name);
    }

    public String getName(){
        return name;
    }
}
