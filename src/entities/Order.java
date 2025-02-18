package entities;

import java.util.List;

public class Order {
    private List<ProductForOrder> products;
    private Customer customer;

    public Order(List<ProductForOrder> products, Customer customer) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ProductForOrder> getProducts() {
        return products;
    }

    protected void setProducts(List<ProductForOrder> products) {
        this.products = products;
    }
}
