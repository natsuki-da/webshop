package se.jensen.natsuki.webshop.model;

public class Rug extends Product {
    private final String category = "rug";

    public String getCategory() {
        return category;
    }

    @Override
    public String category() {
        return category;
    }
}
