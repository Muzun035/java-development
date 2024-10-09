package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    // List all products
                    System.out.println("\nWe carry the following inventory:");
                    Collections.sort(inventory, Comparator.comparing(Product::getName));
                    for (Product product : inventory) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    // Lookup a product by ID
                    System.out.print("Enter product ID to search: ");
                    int id = scanner.nextInt();
                    boolean found = false;
                    for (Product product : inventory) {
                        if (product.getId() == id) {
                            System.out.println("Product found: " + product);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product with ID " + id + " not found.");
                    }
                    break;

                case 3:
                    // Find products within a price range
                    System.out.print("Enter minimum price: ");
                    float minPrice = scanner.nextFloat();
                    System.out.print("Enter maximum price: ");
                    float maxPrice = scanner.nextFloat();

                    System.out.println("\nProducts within price range:");
                    for (Product product : inventory) {
                        if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                            System.out.println(product);
                        }
                    }
                    break;

                case 4:
                    // Add a new product
                    System.out.print("Enter product ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // Consume the leftover newline
                    System.out.print("Enter product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    float newPrice = scanner.nextFloat();

                    Product newProduct = new Product(newId, newName, newPrice);
                    inventory.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 5:
                    // Quit the application
                    keepRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // Manually adding products to the inventory
        inventory.add(new Product(4567, "10' 2x4 (grade B)", 9.99f));
        inventory.add(new Product(1234, "Hammer", 19.49f));
        inventory.add(new Product(2345, "Box of nails", 9.29f));
        inventory.add(new Product(3456, "Screwdriver", 14.59f));
        inventory.add(new Product(5678, "Drill", 49.99f));

        return inventory;

    }

}


