package iostringwriter.longwords;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class LongWordService {

    /*Mire való a StringWriter osztály? Hasonlítsd össze a BufferedWriter-rel és a StringBuilder-rel!
Hosszú szavak
Az első feladatban hosszú szavakat kell kezelned StringWriter segítségével.
Írj egy metódust, ami egy Writer-t és egy listát kap paraméterül, és minden
lista beli elem után írja a szó hosszát! Majd írj egy metódust, ami csak egy
listát vár, és az előzőleg megírt metódust használja a paraéterül kapott listával
és egy példányosított StringWriter-rel!*/

    public void writeWithWriter(List<String> testWords, Writer writer){
        PrintWriter printWriter = new PrintWriter(writer);
        for (String testWord : testWords) {
            printWriter.print(testWord);
            printWriter.print(":");
            printWriter.println(testWord.length());
        }
    }

    public String writeWithStringWriter(List<String> testWords) {
        try(StringWriter newWriter = new StringWriter()){
            writeWithWriter(testWords,newWriter);
            return newWriter.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write!",e);
        }

    }

}
