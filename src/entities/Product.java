package entities;

public class Product {
    private String name;
    private int category; //1 = pizza, 2 = bebida
    private Double price;
    private int size;
    // 1 - small, 2- medium, 3 - large. for pizza and drinks.


    public Product(String name, int category, Double price, int size) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}
