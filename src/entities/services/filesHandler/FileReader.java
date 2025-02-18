package entities.services.filesHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements FileRead {



    public FileReader() {    }

    @Override
    public List<String> getFileLines(Path FILE_PATH) {
        List<String> lines = new ArrayList<>();
        try {
            java.io.FileReader fr = new java.io.FileReader(FILE_PATH.toString());
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line!=null){
                lines.add(line);
                line = br.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


        return lines;
    }

    @Override
    public String getLineByIndex(Path FILE_PATH,int index) {
        String line = null;
        try {
            java.io.FileReader fr = new java.io.FileReader(FILE_PATH.toString());
            BufferedReader br = new BufferedReader(fr);
            for(int i=1; i<=index; i++) {
                line=br.readLine();
            }


        }catch (IOException e){
            e.printStackTrace();
        }


        return line;
    }
}

