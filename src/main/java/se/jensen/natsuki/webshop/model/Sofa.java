package se.jensen.natsuki.webshop.model;

public class Sofa extends Product {
    static final String CATEGORY = "Category: Sofa";

    @Override
    public void category() {
        System.out.println(CATEGORY);
    }


}
