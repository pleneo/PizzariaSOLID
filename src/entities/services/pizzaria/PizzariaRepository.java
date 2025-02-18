package entities.services.pizzaria;

import entities.Pizzaria;

import java.util.List;

public interface PizzariaRepository {
    void addPizzaria(Pizzaria pizzaria);
    void removePizzaria(Pizzaria pizzaria);
    List<Pizzaria> getPizzarias();
    Pizzaria getPizzariaByID(int id);
}
