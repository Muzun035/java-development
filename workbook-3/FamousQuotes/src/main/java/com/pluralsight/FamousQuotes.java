package com.pluralsight;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                "The purpose of our lives is to be happy. - Dalai Lama",
                "Life is what happens when you're busy making other plans. - John Lennon",
                "Get busy living or get busy dying. - Stephen King",
                "You have within you right now, everything you need to deal with whatever the world can throw at you. - Brian Tracy",
                "Believe you can and you're halfway there. - Theodore Roosevelt",
                "The only impossible journey is the one you never begin. - Tony Robbins",
                "Act as if what you do makes a difference. It does. - William James",
                "Success is not how high you have climbed, but how you make a positive difference to the world. - Roy T. Bennett",
                "What you get by achieving your goals is not as important as what you become by achieving your goals. - Zig Ziglar"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            try {
                System.out.print("Enter a number between 1 and 10 to see a quote, or 0 for a random quote: ");
                int index = scanner.nextInt();

                if (index == 0) {
                    index = random.nextInt(quotes.length);
                    System.out.println("Random quote: " + quotes[index]);
                } else if (index > 0 && index <= quotes.length) {
                    System.out.println(quotes[index - 1]);
                } else {
                    System.out.println("Invalid number. Please enter a number between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }

            System.out.print("Do you want to see another quote? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
