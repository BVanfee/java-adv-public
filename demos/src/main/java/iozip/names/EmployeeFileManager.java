package iozip.names;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {
    /*Az iozip.names csomagba készíts egy EmployeeFileManager osztályt!
    Egyetlen metódusa van, a saveEmployees(), mely a paraméterként kapott
    Path által reprezentált zip fájlba létrehoz egy names.dat nevű bináris
    fájlt, és a szintén paraméterként kapott névlista tartalmát beleírja.*/

    public void saveEmployees(Path path, List<String> names){
        try(ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            zos.putNextEntry(new ZipEntry("names.dat"));
            for (String name : names) {
                zos.write(name.getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write zip file.",e);
        }

    }

}
