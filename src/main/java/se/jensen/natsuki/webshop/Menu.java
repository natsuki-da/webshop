package se.jensen.natsuki.webshop;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void chooseProductType() {
        System.out.println("Choose a product type to add\n1: Sofa\n2: Lighting\n3: Rug");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> System.out.println("Sofa");
            case 2 -> System.out.println("Lighting");
            case 3 -> System.out.println("Rug");
            default -> System.out.println("Choose a product type");
        }
    }

    public void addProduct() {
        chooseProductType();

    }

    public void listProducts() {
        System.out.println("List up products");
    }

    public void showProduct() {
        System.out.println("Show products");
    }

    public void exitAdminPortal() {
        System.out.println("Exit");
    }
}
