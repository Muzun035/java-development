package com.pluralsight;

import db.DataManager;
import models.Shipper;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCRUD Operations for Shippers:");
            System.out.println("1. Add a new Shipper");
            System.out.println("2. Display all Shippers ");
            System.out.println("3. Update a Shipper's Phone Number ");
            System.out.println("4. Delete a Shipper");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Shipper Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Shipper Phone: ");
                    String phone = scanner.nextLine();
                    int newId = DataManager.addShipper(name, phone); // addShipper kullanımı
                    if (newId != -1) {
                        System.out.println("New Shipper added with ID: " + newId);
                    } else {
                        System.out.println("Error adding new shipper.");
                    }
                    break;

                case 2:
                    List<Shipper> shippers = DataManager.getAllShippers(); // getAllShippers kullanımı
                    System.out.println("\nShippers List:");
                    for (Shipper shipper : shippers) {
                        System.out.println(shipper);
                    }
                    break;

                case 3:
                    System.out.print("Enter Shipper ID to update phone: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    DataManager.updateShipperPhone(updateId, newPhone); // updateShipperPhone kullanımı
                    System.out.println("Phone number updated!");
                    break;

                case 4:
                    System.out.print("Enter Shipper ID to delete: ");
                    int deleteId = scanner.nextInt();
                    DataManager.deleteShipper(deleteId); // deleteShipper kullanımı
                    System.out.println("Shipper deleted!");
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}