package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        //Question 1: Find the highest salary between Bob and Gary
        double bobSalary = 55000;
        double garySalary = 60000;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest Salary is $" + highestSalary);

        //Question 2: Find the smallest price between car and truck
        double carPrice = 25000;
        double truckPrice = 35000;
        double lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("The lowest price is $" + lowestPrice);

        //Question 3 : Find the area of a circle with radius of 7.25
        double radius = 7.25;
        double areaOfCircle = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is " + areaOfCircle);

        //Question 4: Find the square root of 5.0
        double value = 5.0;
        double sqrtValue = Math.sqrt(value);
        System.out.println("The square root of the" + value + "is" + sqrtValue);

        //Question 5: Find the distance between points (5,10) and (85,50)
        int x1 = 5, y1 = 10;
        int x2 = 85, y2 = 50;
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("The distance between points is " + distance);

        //Question 6: Find the absolute value of -3.8
        double negativeValue = -3.8;
        double absoluteValue = Math.abs(negativeValue);
        System.out.println("The absolute value of " + negativeValue + " is " + absoluteValue);

        //Question 7: Generate a random number between 0 and 1
        double randomNumber = Math.random();
        System.out.println("A random number between 0 and 1 " + randomNumber);

    }
}
