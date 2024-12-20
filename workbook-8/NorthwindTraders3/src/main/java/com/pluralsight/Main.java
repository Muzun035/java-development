package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (args.length != 2) {
                System.out.println("Application needs two arguments to run: <username> <password>");
                System.exit(1);
            }

            String username = args[0];
            String password = args[1];

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("What do you want to do?");
                System.out.println("1) Display all products");
                System.out.println("2) Display all customers");
                System.out.println("0) Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("Exiting the application...");
                    break;
                }

                switch (choice) {
                    case 1:
                        displayAllProducts(connection);
                        break;
                    case 2:
                        displayAllCustomers(connection);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void displayAllProducts(Connection connection) {
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.println("Product List:");
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Units In Stock: " + unitsInStock);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching product data.");
            e.printStackTrace();
        }
    }

    private static void displayAllCustomers(Connection connection) {
        String query = """
            SELECT CompanyName, ContactName, City, Country, Phone
            FROM customers
            ORDER BY Country
            """;
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.println("Customer List:");
            while (results.next()) {
                String companyName = results.getString("CompanyName");
                String contactName = results.getString("ContactName");
                String city = results.getString("City");
                String country = results.getString("Country");
                String phone = results.getString("Phone");

                System.out.printf("Company Name: %s | Contact Name: %s | City: %s | Country: %s | Phone: %s%n",
                        companyName, contactName, city, country, phone);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching customer data.");
            e.printStackTrace();
        }
    }
}