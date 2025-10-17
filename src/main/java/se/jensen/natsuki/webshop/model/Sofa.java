package se.jensen.natsuki.webshop.model;

public class Sofa extends Product {
    private final String category = "sofa";

    public String getCategory() {
        return category;
    }

    @Override
    public String category() {
        return category;
    }


}
