package se.jensen.natsuki.webshop.model;

public class Lighting extends Product {
    static final String CATEGORY = "Category: Lighting";

    @Override
    public void category() {
        System.out.println(CATEGORY);
    }
}
