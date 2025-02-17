package entities.services.filesHandler;

import java.util.List;

public interface FileRead {
    List<String> getFileLines();
    String getLineByIndex(int index);
}
