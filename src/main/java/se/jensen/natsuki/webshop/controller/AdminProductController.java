package se.jensen.natsuki.webshop.controller;

import se.jensen.natsuki.webshop.model.Product;

import java.util.Scanner;

public class AdminProductController implements ProductController {
    private final Scanner scanner;

    public AdminProductController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("Enter an article number; ");
        String articleNumber = scanner.nextLine();
        product.setArticleNumber(articleNumber.toUpperCase());
        System.out.println("Enter a title; ");
        product.setTitle(scanner.nextLine());
        System.out.println("Enter a price; ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter a description; ");
        product.setDescription(scanner.nextLine());
    }

    @Override
    public void listProducts() {
        System.out.println("*** PRODUCT LIST ***");
    }

    @Override
    public void showProduct(String articleNumber) {
    }

}

