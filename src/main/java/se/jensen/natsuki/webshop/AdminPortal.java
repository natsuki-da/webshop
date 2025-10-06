package se.jensen.natsuki.webshop;

import se.jensen.natsuki.webshop.model.Sofa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminPortal {
    //Adminがログイン(Admin class)した後にメニュー(Menu class)を選ぶ
    private Scanner scanner;
    Map<Integer, Object> productsData = new HashMap<>();

    public AdminPortal(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startWorking() {
        Admin admin = new Admin();
        //初めてのユーザーでパスワードがない場合
        setAdmin(admin);
        Menu menu = new Menu(scanner);

        chooseMenu(menu);
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

    public void chooseMenu(Menu menu) {
        System.out.println("Choose from menu:");
        System.out.println("1: Add a product\n2: List up products\n3: Show a specific product\n4. EXIT");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> menu.listProducts();
            case 3 -> menu.showProduct();
            case 4 -> menu.exitAdminPortal();
            default -> System.out.println("You need to choose an option ");
        }
    }

    public void addProduct() {
        Sofa sofa1 = new Sofa();
        System.out.println("Enter article number; ");
        sofa1.setArticleNumber(scanner.nextLine());
        System.out.println("Enter title; ");
        sofa1.setTitle(scanner.nextLine());
        System.out.println("Enter price; ");
        sofa1.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter description; ");
        sofa1.setDescription(scanner.nextLine());
        //System.out.println(sofa1.toString());
        productsData.put(123, sofa1.toString());
        System.out.println("Test1 " + productsData);
        System.out.println("Test2 " + productsData.get(123));
    }


}
