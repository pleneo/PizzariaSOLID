package entities.services.filesHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter implements FileWrite{

    private Path FILE_PATH;
    private String message;

    public FileWriter(Path filePath, String message) {
        FILE_PATH = filePath;
        this.message = message;
    }

    @Override
    public void appendWrite() {
        try{
            Files.write(FILE_PATH, (message + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        }catch (IOException e){
            System.out.println("Erro ao escrever no arquivo " + FILE_PATH);
        }
    }

    @Override
    public void substitutionWrite() {

    }
}
