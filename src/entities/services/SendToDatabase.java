package entities.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SendToDatabase {
    String path = "C:\\Users\\pleneo\\Documents\\Programming\\Java\\Nathalino\\ProjetoPizzariaSOLID\\src\\database\\customers.txt";
    public FileOutputStream fos = new FileOutputStream(path);


    public SendToDatabase() throws FileNotFoundException {
    }



}
