package se.jensen.natsuki.webshop.model;

public class Lighting extends Product {
    private final String category = "lighting";

    public String getCategory() {
        return category;
    }

    @Override
    public String category() {
        return category;
    }
}
