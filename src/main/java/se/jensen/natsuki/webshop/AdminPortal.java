package se.jensen.natsuki.webshop;

import se.jensen.natsuki.webshop.controller.AdminProductController;
import se.jensen.natsuki.webshop.model.*;

import java.util.Scanner;

public class AdminPortal {
    private Scanner scanner;
    private final AdminProductController adminProductController;
    private final ProductFileDao productFileDao;
    private boolean running = true;


    public AdminPortal(Scanner scanner) {
        this.scanner = scanner;
        this.adminProductController = new AdminProductController(scanner);
        this.productFileDao = new ProductFileDao();
    }

    public void startWorking() {
        Admin admin = new Admin();
        //add createAccount() later
        setAdmin(admin);
        chooseMenu();
        //existing admin login
    }

    public void setAdmin(Admin admin) {
        System.out.println("Username:");
        String userName = scanner.nextLine();
        System.out.println("Password:");
        int password = scanner.nextInt();
        admin.setUserName(userName);
        admin.setPassword(password);
    }

    public void chooseMenu() {
        scanner.nextLine();
        while (running) {
            printMenuBar();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> chooseProductType();
                case 2 -> listAllProducts();
                case 3 -> showSpecificProduct();
                case 4 -> leaveAdminPortal();
                default -> System.out.println("You need to choose an option ");
            }
        }
    }

    public void printMenuBar() {
        System.out.println("----- MENU -----");
        System.out.println("(Choose a number from the options below)");
        System.out.println("1: Add a product\n2: List all products\n3: Show a specific product\n4. LEAVE");
    }

    public void chooseProductType() {
        System.out.println("Choose a product type to add\n1: Sofa\n2: Lighting\n3: Rug");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                Sofa sofa = new Sofa();
                adminProductController.addProduct(sofa);
                productFileDao.addProduct(sofa);
            }
            case 2 -> {
                Lighting lighting = new Lighting();
                adminProductController.addProduct(lighting);
                productFileDao.addProduct(lighting);
            }
            case 3 -> {
                Rug rug = new Rug();
                adminProductController.addProduct(rug);
                productFileDao.addProduct(rug);
            }
            default -> System.out.println("Invalid choice. Please select a valid product type.");
        }
    }

    public void listAllProducts() {
        adminProductController.listProducts();
        productFileDao.listProducts();
    }

    public void showSpecificProduct() {
        System.out.println("Please enter the article number you are looking for.");
        String articleNumber = scanner.nextLine();
        productFileDao.showProduct(articleNumber.toUpperCase());
    }

    public void leaveAdminPortal() {
        System.out.println("Great work today!");
        running = false;
    }
}
