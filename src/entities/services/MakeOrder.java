package entities.services;

import entities.Order;
import entities.Pizzaria;

public class MakeOrder {
    private static Pizzaria p;
    private static Order o;

    public MakeOrder() {
    }

    public static void makeOrder(Pizzaria p, Order o){
        p.getOrders().add(o);
    }
}
