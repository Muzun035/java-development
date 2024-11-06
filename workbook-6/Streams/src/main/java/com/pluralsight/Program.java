package com.pluralsight;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Step 1: Create a list of people
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Jane", "Smith", 30));
        people.add(new Person("Alice", "Johnson", 22));
        people.add(new Person("Bob", "Brown", 35));
        people.add(new Person("Emily", "Davis", 28));
        people.add(new Person("Michael", "Wilson", 40));
        people.add(new Person("Sarah", "Lee", 18));
        people.add(new Person("Chris", "Taylor", 29));
        people.add(new Person("Olivia", "Martin", 33));
        people.add(new Person("David", "Anderson", 27));

        // Step 2: Prompt the user for a name to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim();

        // Search for people with matching first or last names
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName) ||
                    person.getLastName().equalsIgnoreCase(searchName)) {
                matchingPeople.add(person);
            }
        }

        // Display matching people
        System.out.println("People with the name \"" + searchName + "\":");
        for (Person person : matchingPeople) {
            System.out.println(person);
        }

        // Step 3: Calculate average age, oldest, and youngest person
        int totalAge = 0;
        int oldestAge = Integer.MIN_VALUE;
        int youngestAge = Integer.MAX_VALUE;

        for (Person person : people) {
            int age = person.getAge();
            totalAge += age;
            if (age > oldestAge) {
                oldestAge = age;
            }
            if (age < youngestAge) {
                youngestAge = age;
            }
        }

        double averageAge = (double) totalAge / people.size();
        System.out.println("\nAverage age: " + averageAge);
        System.out.println("Oldest person age: " + oldestAge);
        System.out.println("Youngest person age: " + youngestAge);
    }
}
