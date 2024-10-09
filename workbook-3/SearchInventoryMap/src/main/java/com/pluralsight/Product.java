package com.pluralsight;

public class Product {
    private int id;
    private String name;
    private float price;

    // Constructor
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter for ID
    public int getId() {
        return this.id;
    }

    // Getter for Name
    public String getName() {
        return this.name;
    }

    // Getter for Price
    public float getPrice() {
        return this.price;
    }

    // Override toString method for easy printing of product details
    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: $" + String.format("%.2f", price);
    }
}
