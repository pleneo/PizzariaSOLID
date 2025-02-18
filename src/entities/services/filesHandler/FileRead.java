package entities.services.filesHandler;

import java.nio.file.Path;
import java.util.List;

public interface FileRead {
    List<String> getFileLines(Path FILE_PATH);
    String getLineByIndex(Path FILE_PATH,int index);
}
