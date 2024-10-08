package com.pluralsight;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String[] stories = {"goldilocks.txt", "hansel_and_gretel.txt", "mary_had_a_little_lamb.txt"};
        Random random = new Random();

        while (true) {
            System.out.print("Enter the name of a story (e.g., goldilocks.txt) or type 'random' for a random story: ");
            String fileName = inputScanner.nextLine();

            if (fileName.equalsIgnoreCase("random")) {
                fileName = stories[random.nextInt(stories.length)];
            }

            File file = new File(fileName);

            try (Scanner fileScanner = new Scanner(file)) {
                int lineNumber = 1;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(lineNumber + ". " + line);
                    lineNumber++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please make sure the file name is correct and try again.");
            }

            System.out.print("Do you want to read another story? (yes/no): ");
            String response = inputScanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        inputScanner.close();
    }
}
