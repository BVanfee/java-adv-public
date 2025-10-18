package ioconvert.shopping;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {
    /*Az ioconvert.shopping csomagba készíts egy ShoppingListManager osztályt!
    A saveShoppingList() metódusa a paraméterül kapott OutputStream-re kiírja
    a szintén paraméterül kapott List<String> tartalmát szövegként, minden
    elemet külön sorba. A loadShoppingList() metódusa a paraméterül kapott
    Inputstream-ből beolvassa a bevásárlólista tartalmát, amit szöveglistaként
    ad vissza.*/

    public void saveShoppingList(OutputStream os, List<String> lines){
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    public List<String> loadShoppingList(InputStream is){
        List<String> shoppingList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine())!=null){
                shoppingList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return shoppingList;
    }
}
