package se.jensen.natsuki.webshop.model;

public class Admin {
    private String userName;
    private int password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        try {
            if (userName == null || userName.isEmpty()) {
                throw new IllegalArgumentException("User name cannot be empty!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        try {
            if (password == 0) {
                throw new IllegalArgumentException("Password cannot be empty!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.password = password;
    }
}
