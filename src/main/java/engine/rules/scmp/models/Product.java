package engine.rules.scmp.models;

import engine.rules.scmp.enums.ProductType;

public class Product {
    private int id;
    private String description;
    private double price;
    private int amount;
    private ProductType type;
    private Rule rule;

    public Product(int id, String description, double price, int amount, ProductType type, Rule rule) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.type = type;
        this.rule = rule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
