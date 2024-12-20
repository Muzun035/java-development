package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByYear;
import com.pluralsight.models.SalesByCategory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "P@ssw0rd");

        System.out.println("Choose an option:");
        System.out.println("1. Search for customer order history");
        System.out.println("2. Search for sales by year");
        System.out.println("3. Search for sales by category");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        switch (choice) {
            case 1:
                System.out.println("Enter a customer ID:");
                String customerID = scanner.nextLine();
                List<CustomerOrderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory(customerID);
                System.out.println("Customer Order History:");
                for (CustomerOrderHistory orderHistory : orderHistoryList) {
                    System.out.println("Product Name: " + orderHistory.getProductName()
                            + ", Total Quantity: " + orderHistory.getTotalQuantity());
                }
                break;
            case 2:
                System.out.println("Enter a year:");
                int year = scanner.nextInt();
                List<SalesByYear> salesByYearList = dataManager.searchSalesByYear(year);
                System.out.println("Sales by Year:");
                for (SalesByYear sales : salesByYearList) {
                    System.out.println("Product Name: " + sales.getProductName()
                            + ", Total Sales: " + sales.getTotalSales());
                }
                break;
            case 3:
                System.out.println("Enter a category name:");
                String categoryName = scanner.nextLine();
                List<SalesByCategory> salesByCategoryList = dataManager.searchSalesByCategory(categoryName);
                System.out.println("Sales by Category:");
                for (SalesByCategory sales : salesByCategoryList) {
                    System.out.println("Product Name: " + sales.getProductName()
                            + ", Total Sales: " + sales.getTotalSales());
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}