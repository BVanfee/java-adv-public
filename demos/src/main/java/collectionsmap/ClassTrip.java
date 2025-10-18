package collectionsmap;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassTrip {
    /*A ClassTrip osztály egy Map<String, Integer> típusú
    attribútumban tárolja osztálykirándulásra már befizetett
    pénzeket. A Map-ben a kulcsok a tanulók nevei, az értékek
    pedig az, hogy ki mennyit fizetett eddig be. Hozd létre
    az osztályt, és benne ezt az attribútumot HashMap-ként,
    getterrel együtt! Az attribútum bejegyzéseit egy fájlból
    töltsd be a loadInpayments(Path path) metódussal, melynek formátuma:*/

    public static final String SEPARATOR = ": ";
    private final Map<String, Integer> inpayments = new HashMap<>();


    public void loadInpayments(Path path){
        try(Scanner scanner = new Scanner(path)){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                lineProcessing(line);
            }
        }catch (IOException ioException){
            throw new IllegalStateException("Can not read file.", ioException);
        }
    }

    public Map<String, Integer> getInpayments() {
        return new HashMap<>(inpayments);
    }

    private void lineProcessing(String line) {
        String[] data = line.split(SEPARATOR);
        inpayments.put(data[0], Integer.parseInt(data[1]));
    }
}
