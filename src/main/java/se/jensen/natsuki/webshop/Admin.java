package se.jensen.natsuki.webshop;

public class Admin {
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

    private String userName;
    private int password;
}
