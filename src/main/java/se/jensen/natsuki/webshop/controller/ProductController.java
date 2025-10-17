package se.jensen.natsuki.webshop.controller;

import se.jensen.natsuki.webshop.model.Product;

public interface ProductController {
    void addProduct(Product product);

    void listProducts();

    void showProduct(String articleNumber);
}
