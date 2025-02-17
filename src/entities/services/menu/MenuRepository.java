package entities.services.menu;

import entities.Product;

import java.util.List;

public interface MenuRepository {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getProducts();
    Product getProductByID(int id);
}
