package ioprintwriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    /*Ebben a feladatban emberek fizetését kell meghatároznod titulus alapján.
    A SalaryWriter osztály konstruktorban kap egy név listát.
    A writeNamesAndSalaries(Path file) metódus kiírja a fájlba név: összeg formátumban.
    A fizetések a következő képpen alakulnak:

Ha tartalmazza a név a "Dr" előtagot, akkor 500000
Ha a "Mr" vagy "Mrs" előtagot akkor 200000
Különben 100000*/

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file){
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){
            for (String name : names) {
                writer.print(name);
                writer.print(": ");
                if(name.contains("Dr")){
                    writer.print(500000);
                } else if (name.contains("Mr")) {
                    writer.print(200000);
                }else{
                    writer.print(100000);
                }
                writer.print("\n");
            }
        }catch (IOException e){
            throw new IllegalStateException("Can not write a file",e);
        }
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }
}
