package entities;

public class ProductForOrder {
    private String name;
    private Double price;
    private int size;

    public ProductForOrder(String name, Double price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}
