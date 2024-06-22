package org.example;

import org.example.controller.ResourceController;
import org.example.controller.UserController;
import org.example.service.ResourceService;
import org.example.service.UserService;
import org.example.view.ConsoleView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        UserService userService = new UserService();
        ResourceService resourceService = new ResourceService();

        UserController userController = new UserController(userService);
        ResourceController resourceController = new ResourceController(resourceService);

        ConsoleView consoleView = new ConsoleView(userController, resourceController);
        consoleView.start();
    }
}