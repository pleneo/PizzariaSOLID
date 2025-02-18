package entities.services.pizzaria;

import entities.Pizzaria;
import entities.services.filesHandler.FileReader;
import entities.services.filesHandler.FileWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePizzariaRepository implements PizzariaRepository {
    private final Path FILE_PATH = Paths.get("C:\\Users\\pleneo\\Documents\\Programming\\Java\\Nathalino\\ProjetoPizzariaSOLID\\src\\database\\pizzarias.txt");
    private final String SEPARATOR = "|";

    public FilePizzariaRepository() {

    }

    @Override
    public void addPizzaria(Pizzaria pizzaria) {
        String productFormattedString = pizzaria.getName()+
                SEPARATOR+pizzaria.getPhone()+
                SEPARATOR+pizzaria.getAddress();

        FileWriter fw = new FileWriter(FILE_PATH, productFormattedString);
        fw.appendWrite();

    }

    @Override
    public void removePizzaria(Pizzaria pizzaria) {

    }

    @Override
    public List<Pizzaria> getPizzarias() {
        FileReader fr = new FileReader();
        List<String> lines = fr.getFileLines(FILE_PATH);
        List<Pizzaria> pizzarias = new ArrayList<>();
        for(String s : lines){
            String[] strs = s.split("\\|");

            pizzarias.add(new Pizzaria(strs[0], strs[1], strs[2]));
        }
        return pizzarias;
    }

    @Override
    public Pizzaria getPizzariaByID(int id) {
        return getPizzarias().get(id);
    }
}
