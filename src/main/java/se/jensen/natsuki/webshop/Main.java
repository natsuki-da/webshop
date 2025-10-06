package se.jensen.natsuki.webshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminPortal adminPortal = new AdminPortal(scanner);
        adminPortal.startWorking();
        scanner.close();

    }
}
