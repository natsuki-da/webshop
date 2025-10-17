package se.jensen.natsuki.webshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "category"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Sofa.class, name = "sofa"),
        @JsonSubTypes.Type(value = Lighting.class, name = "lighting"),
        @JsonSubTypes.Type(value = Rug.class, name = "rug"),
})

public abstract class Product {
    private String articleNumber;
    private String title;
    private int price;
    private String description;

    public String getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "article number: '" + articleNumber + '\'' +
                ", title: '" + title + '\'' +
                ", price: " + price +
                ", description: " + description;
    }

    @JsonProperty("category")
    public abstract String category();

//    public abstract String category();
}