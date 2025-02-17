package entities;

public class Order {
    private Product[] products;

    public Order(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    protected void setProducts(Product[] products) {
        this.products = products;
    }
}
