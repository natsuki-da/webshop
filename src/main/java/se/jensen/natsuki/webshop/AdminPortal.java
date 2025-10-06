package se.jensen.natsuki.webshop;

import se.jensen.natsuki.webshop.model.Lighting;
import se.jensen.natsuki.webshop.model.Product;
import se.jensen.natsuki.webshop.model.Rug;
import se.jensen.natsuki.webshop.model.Sofa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminPortal {
    //Adminがログイン(Admin class)した後にメニュー(Menu class)を選ぶ
    private Scanner scanner;
    Map<String, Object> productsData = new HashMap<>();

    public AdminPortal(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startWorking() {
        Admin admin = new Admin();
        //初めてのユーザーでパスワードがない場合
        setAdmin(admin);
        Menu menu = new Menu(scanner);

        chooseMenu();
        //2回目以降のログインの場合
    }

    public void setAdmin(Admin admin) {
        System.out.println("Username:");
        String userName = scanner.nextLine();
        System.out.println("Password:");
        int password = scanner.nextInt();
        scanner.nextLine();
        admin.setUserName(userName);
        admin.setPassword(password);
    }

    public void login() {
    }

    public void verify() {
    }

    public void chooseMenu() {
        System.out.println("Choose from menu:");
        System.out.println("1: Add a product\n2: List up products\n3: Show a specific product\n4. EXIT");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> chooseProductType();
            case 2 -> listProducts();
            case 3 -> showProduct();
            case 4 -> exitAdminPortal();
            default -> System.out.println("You need to choose an option ");
        }
    }

    public void chooseProductType() {
        System.out.println("Choose a product type to add\n1: Sofa\n2: Lighting\n3: Rug");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                Sofa sofa = new Sofa();
                addProduct(sofa);
            }
            case 2 -> {
                Lighting lighting = new Lighting();
                addProduct(lighting);
            }
            case 3 -> {
                Rug rug = new Rug();
                addProduct(rug);
            }
            default -> System.out.println("Invalid choice. Please select a valid product type.");
        }
    }

    public void addProduct(Product product) {
        System.out.println("Enter article number; ");
        product.setArticleNumber(scanner.nextLine());
        System.out.println("Enter title; ");
        product.setTitle(scanner.nextLine());
        System.out.println("Enter price; ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter description; ");
        product.setDescription(scanner.nextLine());
        productsData.put(product.getArticleNumber(), product.toString());
        chooseMenu();
    }

    public void listProducts() {
        productsData.forEach((key, value) -> System.out.println("TEST YOO " + key + " " + value));
        chooseMenu();
    }

    public void showProduct() {
        System.out.println("Enter the article number you are looking for");
        System.out.println(productsData.get(scanner.nextLine()));
        chooseMenu();
    }

    public void exitAdminPortal() {
        System.out.println("Exit");
    }

}
