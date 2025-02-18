package program;


import entities.Product;
import entities.services.menu.FileMenuRepository;

public class Main {
    public static void main(String[] args) {
        FileMenuRepository fmr = new FileMenuRepository();
        fmr.addProduct(new Product("Pepperoni", 1, 14.50, 15.50, 25.5));


    }
}
