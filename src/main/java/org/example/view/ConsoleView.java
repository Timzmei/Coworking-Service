package org.example.view;

import org.example.controller.ResourceController;
import org.example.controller.UserController;
import org.example.model.Booking;
import org.example.model.Resource;
import org.example.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private UserController userController;
    private ResourceController resourceController;

    private boolean loginUser;
    private User user;

    public ConsoleView(UserController userController, ResourceController resourceController) {
        this.userController = userController;
        this.resourceController = resourceController;
        this.loginUser = false;
        this.user = null;
    }

    public void start() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if(!this.loginUser){
                System.out.println("1. Register");
                System.out.println("2. Login");

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
                    User checkUser = userController.login(username, password);
                    if (userController.login(username, password) != null) {
                        this.loginUser = true;
                        this.user = checkUser;
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                }

            } else {
                System.out.println("3. View All Resources");
                System.out.println("4. View Available Rooms");
                System.out.println("5. Add Workspace");
                System.out.println("6. Add Conference Room");
                System.out.println("7. Remove Resource");
                System.out.println("9. Book Resource");
                System.out.println("10. Cancel Booking");
                System.out.println("11. View All Bookings");
                System.out.println("12. View Available Slots");
                System.out.println("13. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 3) {
                    System.out.println("All Resources:");
                    resourceController.getAllResources().forEach(System.out::println);
                } else if (choice == 4) {
                    System.out.println("Available Resources:");
                    resourceController.getAllAvailableResources().forEach(System.out::println);
                } else if (choice == 5) {
                    resourceController.addWorkspace();
                    System.out.println("Workspace added.");
                } else if (choice == 6) {
                    resourceController.addConferenceRoom();
                    System.out.println("Conference room added.");
                } else if (choice == 7) {
                    System.out.println("Enter resource ID to remove:");
                    int id = scanner.nextInt();
                    if (resourceController.removeResource(id) != null) {
                        System.out.println("Resource removed.");
                    } else {
                        System.out.println("Resource not found.");
                    }
                } else if (choice == 9) {
                    System.out.println("Available Resources:");
                    resourceController.getAllAvailableResources().forEach(System.out::println);
                    System.out.println("Enter resource ID:");
                    int resourceId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter start time (yyyy-MM-ddTHH:mm):");
                    String startTimeString = scanner.nextLine();
                    LocalDateTime startTime = LocalDateTime.parse(startTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    System.out.println("Enter end time (yyyy-MM-ddTHH:mm):");
                    String endTimeString = scanner.nextLine();
                    LocalDateTime endTime = LocalDateTime.parse(endTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);


                    if (resourceController.bookResource(resourceId, this.user, startTime, endTime)) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Booking failed. The resource may not be available.");
                    }
                } else if (choice == 10) {
                    System.out.println("Enter booking ID to cancel:");
                    int id = scanner.nextInt();
                    if (resourceController.cancelBooking(id)) {
                        System.out.println("Booking cancelled.");
                    } else {
                        System.out.println("Booking not found.");
                    }
                } else if (choice == 11) {
                    System.out.println("All bookings:");
                    resourceController.getAllBookings().forEach(System.out::println);
                    System.out.println("Filter Bookings by:");
                    System.out.println("1. User");
                    System.out.println("2. Date");
                    System.out.println("3. Resource");

                    int id = scanner.nextInt();
                    if (id == 1) {
                        System.out.println("Enter username:");
                        String username = scanner.nextLine();
                        resourceController.getBookingsByUser(username).forEach(System.out::println);
                    } else if (id == 2) {
                        System.out.println("Enter date (yyyy-MM-dd):");
                        String dateString = scanner.nextLine();
                        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                        resourceController.getBookingsByDate(date).forEach(System.out::println);
                    } else if (id == 3) {
                        System.out.println("Choice resource type (Workspace/ConferenceRoom):");
                        System.out.println("1. Workspace");
                        System.out.println("2. ConferenceRoom");
                        int type = scanner.nextInt();
                        String resourceType = null;
                        if (type == 1) {
                            resourceType = "Workspace";
                            resourceController.getBookingsByResource(resourceType).forEach(System.out::println);
                        } else if (type == 2) {
                            resourceType = "ConferenceRoom";
                            resourceController.getBookingsByResource(resourceType).forEach(System.out::println);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }

                } else if (choice == 12) {
                    System.out.println("Choice resource type (Workspace/ConferenceRoom):");
                    System.out.println("1. Workspace");
                    System.out.println("2. ConferenceRoom");
                    int type = scanner.nextInt();
                    String resourceType = null;
                    if (type == 1) {
                        resourceType = "Workspace";
                    } else if (type == 2) {
                        resourceType = "ConferenceRoom";
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter date (yyyy-MM-dd):");
                    String dateString = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

                    List<Resource> bookings = resourceController.getBookingsForResourceOnDate(resourceType, date);
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings for the selected resource on the specified date.");
                    } else {
                        System.out.println("Bookings for the selected resource on the specified date:");
                        bookings.forEach(System.out::println);
                    }
                }
                else if (choice == 13) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }

        }
        scanner.close();
    }
}