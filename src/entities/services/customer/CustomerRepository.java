package entities.services.customer;

import entities.Customer;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer getCustomerByID(int id);
}
