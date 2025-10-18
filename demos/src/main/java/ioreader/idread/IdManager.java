package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    /*A idread csomagban készítsd el az IdManager osztályt.
    Ez az osztály felelős az idnumbers.txt (kitalált) személyi igazolvány
    számokat tartalmazó szöveges állomány feldolgozásáért. A readIdsFromFile()
    metódus megkap egy fájlnevet, és annak sorait tárolja el az List<String> ids listában.*/

    private List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String name) {
        Path fileName = Path.of("src/main/resources/ioreader/" + name);
        try (BufferedReader bufferedReader = Files.newBufferedReader(fileName)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File can not read: " + name, e);
        }

    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}
