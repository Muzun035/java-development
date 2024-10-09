package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {

    // HashMap to store product inventory. The key is the product name, the value is the Product object.
    static HashMap<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        // Load inventory from CSV file
        loadInventory();

        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        boolean keepSearching = true;

        // Repeat the search until the user decides to quit
        while (keepSearching) {
            // Prompt user for product name
            System.out.print("What product are you interested in? ");
            String productName = scanner.nextLine().trim();

            // Get the product from the inventory
            Product matchedProduct = inventory.get(productName);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product.");
            } else {
                // Display product details if found
                System.out.printf("We carry %s, and the price is $%.2f%n",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            // Ask the user if they want to search again
            System.out.print("Do you want to search again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            keepSearching = response.equals("yes");
        }

        // Close scanner
        scanner.close();
        System.out.println("Thank you for using the inventory search!");
    }

    // Method to load inventory from CSV file
    public static void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing whitespace
                String[] tokens = line.split("\\|");

                // Extract product details from the CSV line
                int id = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                float price = Float.parseFloat(tokens[2].trim());

                // Create a new product and add it to the inventory HashMap
                Product product = new Product(id, name, price);
                inventory.put(name, product);
            }
        } catch (IOException e) {
            System.out.println("Could not read from file. Loading default inventory.");
            // Load default inventory if file cannot be read
            inventory.put("10' 2x4 (grade B)", new Product(4567, "10' 2x4 (grade B)", 9.99f));
            inventory.put("Hammer", new Product(1234, "Hammer", 19.49f));
            inventory.put("Box of nails", new Product(2345, "Box of nails", 9.29f));
            inventory.put("Screwdriver", new Product(3456, "Screwdriver", 14.59f));
            inventory.put("Drill", new Product(5678, "Drill", 49.99f));
        }
    }
}
