package com.pluralsight;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim();

        // Step 1: Search using stream and filter
        List<Person> matchingPeople = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(searchName) ||
                        person.getLastName().equalsIgnoreCase(searchName))
                .toList();

        System.out.println("People with the name \"" + searchName + "\":");
        matchingPeople.forEach(System.out::println);

        // Step 2: Calculate average age using streams
        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println("\nAverage age: " + averageAge);

        // Step 3: Find oldest and youngest ages using streams
        int oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);


        System.out.println("Oldest person age: " + oldestAge);
        System.out.println("Youngest person age: " + youngestAge);
    }
}
