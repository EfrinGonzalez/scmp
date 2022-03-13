package engine.rules.scmp.models;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Product> products;

    public Order(int id, ArrayList<Product> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
