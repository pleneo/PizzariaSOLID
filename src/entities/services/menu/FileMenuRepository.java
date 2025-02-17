package entities.services.menu;

import entities.Product;
import entities.services.filesHandler.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileMenuRepository implements MenuRepository {

    private final Path FILE_PATH = Paths.get("src/database/menu.txt");
    private final String SEPARATOR = "|";

    public FileMenuRepository() {
    }

    @Override
    public void addProduct(Product product) {
        String productFormattedString = product.getName()+SEPARATOR+product.getCategory()+SEPARATOR+product.getPrice()+SEPARATOR+product.getSize();

        FileWriter fw = new FileWriter(FILE_PATH, productFormattedString);
        fw.appendWrite();
    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductByID(int id) {
        return null;
    }
}
