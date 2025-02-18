package entities;

public class Product {
    private String name;
    private int category; //1 = pizza, 2 = bebida
    private Double smallPrice;
    private Double mediumPrice;
    private Double largePrice;

    public Product(String name, int category, Double smallPrice, Double mediumPrice, Double largePrice) {
        this.name = name;
        this.category = category;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public Double getSmallPrice() {
        return smallPrice;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public Double getLargePrice() {
        return largePrice;
    }
}
