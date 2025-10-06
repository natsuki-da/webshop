package se.jensen.natsuki.webshop.model;

public class Sofa extends Product {
    static final String category = "sofa";

    @Override
    public void category() {
        System.out.println(category);
    }


}
