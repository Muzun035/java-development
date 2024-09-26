package com.pluralsight;

import java.util.Scanner;
public class PayrollCalculator {

    public static void main(String[] args) {
        //Step 1: Declare variables
        String employeeName;
        double hoursWorked;
        double payRate;
        double grossPay;

        //Step 2: Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        //Step 3: Get employee's name
        System.out.println("Enter your name:");
        employeeName = scanner.nextLine();

        //Step 4: Getting weekly work hours
        System.out.println("Enter your total weekly work hours");
        hoursWorked = scanner.nextDouble();

        //Step 5: Getting pay rate
        System.out.println("Enter your pay rate:");
        payRate = scanner.nextDouble();

        //Step 6: Calculate gross pay (with overtime)
        if (hoursWorked > 40) {
            double overtimeHours = hoursWorked - 40;
            grossPay = (40* payRate) + (overtimeHours * payRate * 1.5);
        } else {
            grossPay = hoursWorked * payRate;
    }
        // Step 7: Displaying the results
        System.out.println("Employee Name:" + employeeName);
        System.out.println("Gross Pay:" + grossPay);}
}
