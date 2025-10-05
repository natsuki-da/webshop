package se.jensen.natsuki.webshop;

import java.util.Scanner;

public class AdminPortal {
    //Adminがログイン(Admin class)した後にメニュー(Menu class)を選ぶ
    private Scanner scanner;

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
            case 1 -> menu.addProduct();
            case 2 -> menu.listProducts();
            case 3 -> menu.showProduct();
            case 4 -> menu.exitAdminPortal();
            default -> System.out.println("You need to choose an option ");
        }
    }
}
