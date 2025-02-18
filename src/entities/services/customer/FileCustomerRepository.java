package entities.services.customer;

import entities.Customer;
import entities.services.filesHandler.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileCustomerRepository implements CustomerRepository{

    private final Path FILE_PATH = Paths.get("C:\\Users\\pleneo\\Documents\\Programming\\Java\\Nathalino\\ProjetoPizzariaSOLID\\src\\database\\customers.txt");
    private final String SEPARATOR = "|";

    public FileCustomerRepository() {
    }

    @Override
    public void addCustomer(Customer customer) {
        String productFormattedString = customer.getName()+
                SEPARATOR+customer.getAddress()+
                SEPARATOR+customer.getPhone();

        FileWriter fw = new FileWriter(FILE_PATH, productFormattedString);
        fw.appendWrite();
    }

    @Override
    public void removeCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerByID(int id) {
        return null;
    }
}
