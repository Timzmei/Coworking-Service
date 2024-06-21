package org.example.view;

import org.example.controller.UserController;

import java.util.Scanner;

public class ConsoleView {
    private UserController userController;

    public ConsoleView(UserController userController) {
        this.userController = userController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                if (userController.register(username, password)) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Username already exists!");
                }
            } else if (choice == 2) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                if (userController.login(username, password) != null) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}