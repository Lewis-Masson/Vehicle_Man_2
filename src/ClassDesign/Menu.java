package ClassDesign;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); 
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine(); 
        return input;
    }

    public double getDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            System.out.print(prompt);
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); 
        return input;
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    
}