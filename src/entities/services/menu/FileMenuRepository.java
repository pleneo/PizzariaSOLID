package entities.services.menu;

import entities.Pizzaria;
import entities.Product;
import entities.services.filesHandler.FileReader;
import entities.services.filesHandler.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileMenuRepository implements MenuRepository {

    private final Path FILE_PATH = Paths.get("C:\\Users\\pleneo\\Documents\\Programming\\Java\\Nathalino\\ProjetoPizzariaSOLID\\src\\database\\menu.txt");
    private final String SEPARATOR = "|";

    public FileMenuRepository() {
    }

    @Override
    public void addProduct(Product product) {
        String productFormattedString = product.getName()+
                SEPARATOR+product.getCategory()+
                SEPARATOR+product.getSmallPrice()+
                SEPARATOR+product.getMediumPrice()+
                SEPARATOR+product.getLargePrice();

        FileWriter fw = new FileWriter(FILE_PATH, productFormattedString);
        fw.appendWrite();
    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {
        FileReader fr = new FileReader();
        List<String> lines = fr.getFileLines(FILE_PATH);
        List<Product> products = new ArrayList<>();
        for(String s : lines){
            String[] strs = s.split("\\|");

            products.add(new Product(strs[0],Integer.parseInt(strs[1]), Double.parseDouble(strs[2]),Double.parseDouble(strs[3]), Double.parseDouble(strs[4])));
        }
        return products;
    }

    @Override
    public Product getProductByID(int id) {
        return getProducts().get(id);
    }
}
