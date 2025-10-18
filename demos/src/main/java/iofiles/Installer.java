package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {
    /*Készíts egy Installer osztályt, egyetlen install() metódussal,
    mely paraméterként a telepítési mappát kapja meg String-ként.
    A megadott mappán belülre másold át a classpathról az install mappában
    lévő fájlokat és mappákat az install mappából! Az install.txt fájlban a
    / jelre végződő sorok mappákat jelölnek, ezeket létre kell hoznod, mielőtt
    fájlokat másolnál bele. Az esetleges sikertelen telepítésből visszamaradt
    fájlokat mindig írd felül! Ha a paraméterül kapott mappa nem létezik vagy
    nem is mappa, dobj IllegalArgumentException kivételt!*/


    public void install(String installFolder) {
        Path path = Path.of(installFolder);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/install/install.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.endsWith("/")){
                    Files.createDirectories(path.resolve(line));
                }else{
                    Files.copy(this.getClass().getResourceAsStream("/install/"+line),
                    path.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Cannot copy files.", e);
        }
    }
}
