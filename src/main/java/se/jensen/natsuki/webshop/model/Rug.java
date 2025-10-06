package se.jensen.natsuki.webshop.model;

public class Rug extends Product {
    static final String CATEGORY = "Category: Rug";

    @Override
    public void category() {
        System.out.println(CATEGORY);
    }
}
