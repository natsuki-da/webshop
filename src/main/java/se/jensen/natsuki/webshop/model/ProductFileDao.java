package se.jensen.natsuki.webshop.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import se.jensen.natsuki.webshop.controller.ProductController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ProductFileDao implements ProductController {
    private ObjectMapper mapper = new ObjectMapper();
    private String product_json;
    private Path productJson_file = Path.of("src/main/java/se/jensen/natsuki/webshop/data/products.json");
    private Map<String, Product> productsData = new HashMap<>();
    private Map<String, Product> deserializeProducJson;

    public void encodeProductDataToJSON() {
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            product_json = mapper.writeValueAsString(productsData);
        } catch (JsonProcessingException e) {
            System.out.println("JSON processing error: " + e.getMessage());
        }
    }

    public void writeToJSON() throws IOException {
        encodeProductDataToJSON();
        if (Files.notExists(productJson_file)) {
            Path parent = productJson_file.getParent();
            if (parent != null && Files.notExists(parent)) {
                Files.createDirectories(parent);
            }
            System.out.println("No file exists");
            Files.createFile(productJson_file);
        }
        if (product_json == null) {
            throw new IOException("product_json is empty, nothing to write");
        }
        Files.writeString(productJson_file, product_json);
    }

    public void deserializeProductJson() {
        try {
            deserializeProducJson = mapper.readValue(productJson_file.toFile(), mapper.getTypeFactory().constructMapType(HashMap.class, String.class, Product.class));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addProduct(Product product) {
        productsData.put(product.getArticleNumber(), product);
        try {
            writeToJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listProducts() {
        //productsData.forEach((key, value) -> System.out.println(key + " // " + value));
        deserializeProductJson();
        deserializeProducJson.forEach((key, value) -> System.out.println(key + " // " + value));
    }

    @Override
    public void showProduct(String articleNumber) {
        deserializeProductJson();
        Product specificProduct = deserializeProducJson.get(articleNumber);
        if (specificProduct != null) {
            System.out.println(specificProduct);
        } else {
            System.out.println("No product found with this article number: " + articleNumber);
        }
    }
}
