package entities;

import java.util.List;

public class Pizzaria {
    private String name;
    private String address;
    private String phone;
    private Menu menu;
    private List<Order> orders;

    public Pizzaria(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
